import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ProductDAO productDAO = new ProductDAO();
        UserDAO userDAO = new UserDAO();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n*** MENU PRINCIPAL ***");
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Gerenciar Usuários");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    gerenciarProdutos(scanner, productDAO);
                    break;

                case 2:
                    gerenciarUsuarios(scanner, userDAO);
                    break;

                case 3:
                    running = false;
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void gerenciarProdutos(Scanner scanner, ProductDAO productDAO) {
        boolean managingProducts = true;

        while (managingProducts) {
            System.out.println("\n*** GERENCIAR PRODUTOS ***");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Listar Produtos");
            System.out.println("3. Atualizar Produto");
            System.out.println("4. Excluir Produto");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // Adicionar Produto
                    System.out.print("Nome do Produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Código do Produto: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Descrição do Produto: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Preço do Produto: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha

                    Product newProduct = new Product(nome, codigo, descricao, preco);
                    productDAO.addProduct(newProduct);
                    break;

                case 2:
                    // Listar Produtos
                    List<Product> products = productDAO.getAllProducts();
                    System.out.println("\n*** LISTA DE PRODUTOS ***");
                    if (products.isEmpty()) {
                        System.out.println("Nenhum produto encontrado.");
                    } else {
                        for (Product product : products) {
                            System.out.println(product.getId() + ": " + product.getNomeDoProduto() + " - R$ " + product.getPrecoDoProduto());
                        }
                    }
                    System.out.println("\nPressione Enter para voltar ao menu de gerenciamento de produtos.");
                    scanner.nextLine(); // Pausa para o usuário ler a lista
                    break;

                case 3:
                    // Atualizar Produto
                    System.out.print("ID do Produto a atualizar: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    System.out.print("Novo Nome do Produto: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo Código do Produto: ");
                    String novoCodigo = scanner.nextLine();
                    System.out.print("Nova Descrição do Produto: ");
                    String novaDescricao = scanner.nextLine();
                    System.out.print("Novo Preço do Produto: ");
                    double novoPreco = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a nova linha

                    Product updateProduct = new Product(idToUpdate, novoNome, novoCodigo, novaDescricao, novoPreco);
                    productDAO.updateProduct(updateProduct);
                    break;

                case 4:
                    // Excluir Produto
                    System.out.print("ID do Produto a excluir: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    productDAO.deleteProduct(idToDelete);
                    break;

                case 5:
                    // Voltar ao Menu Principal
                    managingProducts = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    private static void gerenciarUsuarios(Scanner scanner, UserDAO userDAO) {
        boolean managingUsers = true;

        while (managingUsers) {
            System.out.println("\n*** GERENCIAR USUÁRIOS ***");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Listar Usuários");
            System.out.println("3. Atualizar Usuário");
            System.out.println("4. Excluir Usuário");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    // Cadastrar Usuário
                    System.out.print("Nome do Usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Email do Usuário: ");
                    String email = scanner.nextLine();
                    System.out.print("Senha do Usuário: ");
                    String senha = scanner.nextLine();

                    User newUser = new User(nome, email, senha);
                    userDAO.addUser(newUser);
                    break;

                case 2:
                    // Listar Usuários
                    List<User> users = userDAO.getAllUsers();
                    System.out.println("\n*** LISTA DE USUÁRIOS ***");
                    if (users.isEmpty()) {
                        System.out.println("Nenhum usuário encontrado.");
                    } else {
                        for (User user : users) {
                            System.out.println(user.getId() + ": " + user.getNome() + " - Email: " + user.getEmail());
                        }
                    }
                    System.out.println("\nPressione Enter para voltar ao menu de gerenciamento de usuários.");
                    scanner.nextLine(); // Pausa para o usuário ler a lista
                    break;

                case 3:
                    // Atualizar Usuário
                    System.out.print("ID do Usuário a atualizar: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    System.out.print("Novo Nome do Usuário: ");
                    String novoNome = scanner.nextLine();
                    System.out.print("Novo Email do Usuário: ");
                    String novoEmail = scanner.nextLine();
                    System.out.print("Nova Senha do Usuário: ");
                    String novaSenha = scanner.nextLine();

                    User updateUser = new User(idToUpdate, novoNome, novoEmail, novaSenha);
                    userDAO.updateUser(updateUser);
                    break;

                case 4:
                    // Excluir Usuário
                    System.out.print("ID do Usuário a excluir: ");
                    int idToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha
                    userDAO.deleteUser(idToDelete);
                    break;

                case 5:
                    // Voltar ao Menu Principal
                    managingUsers = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}

