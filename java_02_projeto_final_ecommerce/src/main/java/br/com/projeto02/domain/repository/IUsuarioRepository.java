package br.com.projeto02.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projeto02.domain.model.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	public boolean existsByCpfUsuario(String cpfUsuario);

	public Usuario findByCpfUsuario(String cpfUsuario);

	public Usuario findByIdUsuario(int idUsuario);

}
