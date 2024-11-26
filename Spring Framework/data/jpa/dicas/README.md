## Padrões de Carregamento (FetchType) nas Anotações do JPA

As anotações do JPA possuem diferentes padrões de carregamento (**FetchType**) dependendo do tipo de relacionamento. Abaixo está um resumo:

| Anotação      | Padrão (`FetchType`) | Comportamento                                                                 |
|---------------|----------------------|-------------------------------------------------------------------------------|
| **@OneToOne** | `EAGER`             | O relacionamento é carregado **imediatamente** junto com a entidade principal. |
| **@ManyToOne**| `EAGER`             | O relacionamento é carregado **imediatamente**, como no caso do `@OneToOne`.   |
| **@OneToMany**| `LAZY`              | O relacionamento é carregado de forma **lenta** e só será recuperado quando acessado explicitamente. |
| **@ManyToMany**| `LAZY`             | Também carregado de forma **lenta**, sendo recuperado apenas quando necessário. |

### Alterando o Comportamento

Você pode sobrescrever o padrão de carregamento adicionando o atributo `fetch` na anotação. Exemplo:

```java
@OneToOne(fetch = FetchType.LAZY)
private Detalhes detalhes;

@ManyToOne(fetch = FetchType.LAZY)
private Categoria categoria;
