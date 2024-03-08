import java.util.Arrays;
import java.util.Optional;

public enum EmpresaEnum {

    MAGAZINE_LUIZA(1, "Magazine Luiza S.A."),
    LOJAS_AMERICANAS(2, "Lojas Americanas S.A."),
    GRUPO_PAO_DE_ACUCAR(3, "Companhia Brasileira de Distribuição"),
    CASAS_BAHIA(4, "Via Varejo S.A."),
    BRADESCO(5, "Banco Bradesco S.A."),
    PETROBRAS(6, "Petroleo Brasileiro S.A. - Petrobras"),
    VALE(7, "Vale S.A."),
    AMBEV(8, "Ambev S.A."),
    ITAU_UNIBANCO(9, "Itaú Unibanco Holding S.A."),
    NATURA(10, "Natura &Co Holding S.A."),
    EMBRAER(11, "Embraer S.A.");

    EmpresaEnum(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    private final int codigo;
    private final String nome;

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public static Optional<EmpresaEnum> get(int codigo) {
        return Arrays.stream(EmpresaEnum.values())
                .filter(e -> e.getCodigo() == codigo)
                .findFirst();
    }
}