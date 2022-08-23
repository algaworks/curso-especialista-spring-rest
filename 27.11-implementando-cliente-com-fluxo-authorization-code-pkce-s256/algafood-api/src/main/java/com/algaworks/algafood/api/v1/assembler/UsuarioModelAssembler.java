package com.algaworks.algafood.api.v1.assembler;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.UsuarioController;
import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.core.security.AlgaSecurity;
import com.algaworks.algafood.domain.model.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class UsuarioModelAssembler 
		extends RepresentationModelAssemblerSupport<Usuario, UsuarioModel> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AlgaLinks algaLinks;
	
	@Autowired
	private AlgaSecurity algaSecurity;
	
	public UsuarioModelAssembler() {
		super(UsuarioController.class, UsuarioModel.class);
	}
	
	@Override
	public UsuarioModel toModel(Usuario usuario) {
		UsuarioModel usuarioModel = createModelWithId(usuario.getId(), usuario);
		modelMapper.map(usuario, usuarioModel);
		
		if (algaSecurity.podeConsultarUsuariosGruposPermissoes()) {
			usuarioModel.add(algaLinks.linkToUsuarios("usuarios"));
			
			usuarioModel.add(algaLinks.linkToGruposUsuario(usuario.getId(), "grupos-usuario"));
		}
		
		return usuarioModel;
	}
	
	@Override
	public CollectionModel<UsuarioModel> toCollectionModel(Iterable<? extends Usuario> entities) {
		CollectionModel<UsuarioModel> collectionModel = super.toCollectionModel(entities);
		
		if (algaSecurity.podeConsultarUsuariosGruposPermissoes()) {
			collectionModel.add(algaLinks.linkToUsuarios());
		}
		
		return collectionModel;
	}
	
}
