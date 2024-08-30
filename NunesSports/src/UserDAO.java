import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private List<User> users = new ArrayList<>();
    private int nextId = 1; // Simula o auto incremento do banco de dados

    // Método para adicionar um usuário
    public void addUser(User user) {
        user.setId(nextId++);
        users.add(user);
        System.out.println("Usuário cadastrado com sucesso: " + user.getNome());
    }

    // Método para listar todos os usuários
    public List<User> getAllUsers() {
        return users;
    }

    // Método para atualizar um usuário
    public void updateUser(User user) {
        for (User u : users) {
            if (u.getId() == user.getId()) {
                u.setNome(user.getNome());
                u.setEmail(user.getEmail());
                u.setSenha(user.getSenha());
                System.out.println("Usuário atualizado com sucesso: " + user.getNome());
                return;
            }
        }
        System.out.println("Usuário não encontrado para atualização: ID " + user.getId());
    }

    // Método para excluir um usuário
    public void deleteUser(int id) {
        boolean removed = users.removeIf(user -> user.getId() == id);
        if (removed) {
            System.out.println("Usuário excluído com sucesso: ID " + id);
        } else {
            System.out.println("Usuário não encontrado para exclusão: ID " + id);
        }
    }
}
