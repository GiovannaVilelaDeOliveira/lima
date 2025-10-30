package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModeloDao {
	
	private static List<Modelo> modeloList = new ArrayList<Modelo>();
	
	public void cadastrar(Modelo pratoInformado) {
		modeloList.add(pratoInformado);
	}
	
	public List<Modelo> consultar(){
		return modeloList;
	}
	
	public void excluir(Integer id) {
		modeloList = modeloList.stream()
				.filter(prato -> prato.getCodigo() != id)
				.collect(Collectors.toList());
	}
	

}
