public class Product {
    private int id;
    private String nomeDoProduto;
    private String codigoDoProduto;
    private String descricaoDoProduto;
    private double precoDoProduto;

    // Construtores
    public Product(String nomeDoProduto, String codigoDoProduto, String descricaoDoProduto, double precoDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
        this.codigoDoProduto = codigoDoProduto;
        this.descricaoDoProduto = descricaoDoProduto;
        this.precoDoProduto = precoDoProduto;
    }

    public Product(int id, String nomeDoProduto, String codigoDoProduto, String descricaoDoProduto, double precoDoProduto) {
        this.id = id;
        this.nomeDoProduto = nomeDoProduto;
        this.codigoDoProduto = codigoDoProduto;
        this.descricaoDoProduto = descricaoDoProduto;
        this.precoDoProduto = precoDoProduto;
    }

    // Getters e setters
    public int getId() {
        return id;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public String getCodigoDoProduto() {
        return codigoDoProduto;
    }

    public String getDescricaoDoProduto() {
        return descricaoDoProduto;
    }

    public double getPrecoDoProduto() {
        return precoDoProduto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public void setCodigoDoProduto(String codigoDoProduto) {
        this.codigoDoProduto = codigoDoProduto;
    }

    public void setDescricaoDoProduto(String descricaoDoProduto) {
        this.descricaoDoProduto = descricaoDoProduto;
    }

    public void setPrecoDoProduto(double precoDoProduto) {
        this.precoDoProduto = precoDoProduto;
    }
}
