package herrera.martin.login.daos;

import herrera.martin.login.models.Usuario;

import java.util.HashSet;
import java.util.Set;

public class UsuariosDao {
    Set<Usuario>listaUsuarioDao;

    public UsuariosDao() {
        listaUsuarioDao=new HashSet<>();
    }

    public Set<Usuario> getUsuarios(){
        listaUsuarioDao.add(new Usuario("bien","123"));
        listaUsuarioDao.add(new Usuario("mal","1234"));
        listaUsuarioDao.add(new Usuario("nose","12345"));

        return listaUsuarioDao;
    }
    public boolean usuarioExist(Usuario validar){
        //implementar un compare
      //  listaUsuarioDao.stream().anyMatch(user-> user.getUsuario().equals(validar.getUsuario()));
        listaUsuarioDao=getUsuarios();
        for (Usuario usr:listaUsuarioDao) {
    if (usr.getUsuario().equals(validar.getUsuario())&&
            usr.getPassword().equals(validar.getPassword())){
        return true;
    }
        }
        return false;
    }
}

