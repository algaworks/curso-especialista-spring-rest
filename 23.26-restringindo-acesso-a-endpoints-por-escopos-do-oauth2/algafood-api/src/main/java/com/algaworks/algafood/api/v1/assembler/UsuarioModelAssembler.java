package com.algaworks.algafood.api.v1.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.api.v1.AlgaLinks;
import com.algaworks.algafood.api.v1.controller.UsuarioController;
import com.algaworks.algafood.api.v1.model.UsuarioModel;
import com.algaworks.algafood.domain.model.Usuario;

@Component
public class UsuarioModelAssembler 
		extends RepresentationModelAssemblerSupport<Usuario, UsuarioModel> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private AlgaLinks algaLinks;
	
	public UsuarioModelAssembler() {
		super(UsuarioController.class, UsuarioModel.class);
	}
	
	@Override
	public UsuarioModel toModel(Usuario usuario) {
		UsuarioModel usuarioModel = createModelWithId(usuario.getId(), usuario);
		modelMapper.map(usuario, usuarioModel);
		
		usuarioModel.add(algaLinks.linkToUsuarios("usuarios"));
		
		usuarioModel.add(algaLinks.linkToGruposUsuario(usuario.getId(), "grupos-usuario"));
		
		return usuarioModel;
	}
	
	@Override
	public CollectionModel<UsuarioModel> toCollectionModel(Iterable<? extends Usuario> entities) {
		return super.toCollectionModel(entities)
			.add(algaLinks.linkToUsuarios());
	}
	
}
