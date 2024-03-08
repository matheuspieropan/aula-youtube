import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite código da empresa: ");
        int codigo = scanner.nextInt();

        Empresa empresa = new Empresa();

       /*  EVITE FAZER ISSO
        if (EmpresaEnum.EMBRAER.getCodigo() == codigo) {
            empresa.setNome(EmpresaEnum.EMBRAER.getNome());
        } else if (EmpresaEnum.LOJAS_AMERICANAS.getCodigo() == codigo) {
            empresa.setNome(EmpresaEnum.LOJAS_AMERICANAS.getNome());
        }
        */
        EmpresaEnum.get(codigo).ifPresent(e -> empresa.setNome(e.getNome()));
        System.out.println(empresa.getNome());
    }
}