import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Handler implements RequestHandler<S3Event, String> {

    private final AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
            .withRegion(Regions.US_EAST_1).build();

    @Override
    public String handleRequest(S3Event s3Event, Context context) {
        s3Event.getRecords().forEach(s3 -> {

            String bucketName = s3.getS3().getBucket().getName();
            String key = s3.getS3().getObject().getKey();

            InputStream inputStream = s3Client.getObject(bucketName, key).getObjectContent();
            try {

                BufferedImage originalImage = ImageIO.read(inputStream);
                BufferedImage imagemRedimensionada = resizeImage(originalImage);

                enviarS3(bucketName, key, imagemRedimensionada);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return "OK";
    }

    private BufferedImage resizeImage(BufferedImage originalImage) {
        BufferedImage resizedImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = resizedImage.createGraphics();
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.drawImage(originalImage, 0, 0, 100, 100, null);
        graphics2D.dispose();

        return resizedImage;
    }

    private void enviarS3(String bucketName, String key, BufferedImage image) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", os);
        byte[] buffer = os.toByteArray();
        ByteArrayInputStream is = new ByteArrayInputStream(buffer);

        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setContentLength(buffer.length);

        s3Client.putObject(new PutObjectRequest(bucketName, "redimensionadas/" + key, is, metadata));
    }
}