## Como utilizar o SDK AWS S3

Primeiramente precisamos definir nossos beans que permitirão utilizar os serviços da aws. 

#### _@AWSCredentials_

Este bean se refere as credenciais. Você vai precisar de uma chave de acesso e uma chave secreta.

Coloquei abaixo um print mostrando o caminho e em vermelho onde clicar para obter as chaves

![img.png](img.png)

caso ainda encontre dificuldade [clique aqui e leia documentação](https://aws.amazon.com/pt/blogs/aws-brasil/onde-esta-minha-secret-access-key/)

#### _@AmazonS3_

Este bean nos permite configurar um client para o S3. Precisamos
referenciar nele as credenciais criadas no bean anterior e definir
em qual Região da AWS vamos trabalhar. No caso **_US_EAST_1_**


#### Salvando no S3

Uma vez que configuramos o bean citado anteriormente (AmazonS3) basta
utilizarmos ele chamando o método putObject. Esse método recebe um PutObjectRequest como parâmetro.

PutObjectRequest pode ser instanciado através de um construtor que espera três
parâmetros:
* _Nome do bucket_
* _Nome do arquivo_
* _O próprio arquivo_

Chamamos o método e pronto ;) <br>

Salvo com sucesso

![img_1.png](img_1.png)