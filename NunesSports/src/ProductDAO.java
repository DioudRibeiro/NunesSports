import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private List<Product> products = new ArrayList<>();
    private int nextId = 1; // Simula o auto incremento do banco de dados

    // Método para adicionar um produto
    public void addProduct(Product product) {
        product.setId(nextId++);
        products.add(product);
        System.out.println("Produto adicionado com sucesso: " + product.getNomeDoProduto());
    }

    // Método para listar todos os produtos
    public List<Product> getAllProducts() {
        return products;
    }

    // Método para atualizar um produto
    public void updateProduct(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                p.setNomeDoProduto(product.getNomeDoProduto());
                p.setCodigoDoProduto(product.getCodigoDoProduto());
                p.setDescricaoDoProduto(product.getDescricaoDoProduto());
                p.setPrecoDoProduto(product.getPrecoDoProduto());
                System.out.println("Produto atualizado com sucesso: " + product.getNomeDoProduto());
                return;
            }
        }
        System.out.println("Produto não encontrado para atualização: ID " + product.getId());
    }

    // Método para excluir um produto
    public void deleteProduct(int id) {
        boolean removed = products.removeIf(product -> product.getId() == id);
        if (removed) {
            System.out.println("Produto excluído com sucesso: ID " + id);
        } else {
            System.out.println("Produto não encontrado para exclusão: ID " + id);
        }
    }
}

