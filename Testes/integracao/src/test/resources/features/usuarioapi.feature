# language: pt
Funcionalidade: Listar Usuários

  Como um cliente da API
  Quero obter uma lista de usuários
  Para visualizar todos os usuários cadastrados no sistema

  Cenário: Listar todos os usuários com sucesso
    Dado que existem usuários cadastrados no sistema:
      | nome           | email                      | idade |
      | Alice Silva    | alice.silva@example.com    | 25    |
      | Bruno Costa    | bruno.costa@example.com    | 30    |
      | Carla Ferreira | carla.ferreira@example.com | 22    |
    Quando eu faço uma requisição GET para obter usuários
    Então a resposta deve ter o status code 200
    E a resposta deve conter os dados que foram cadastrados previamente