package marca;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MarcaDao {
 private static List<Marca> marcaList = new ArrayList<Marca>();
	
	public void cadastrar(Marca pratoInformado) {
		marcaList.add(pratoInformado);
	}
	
	public List<Marca> consultar(){
		return marcaList;
	}
	
	public void excluir(Integer id) {
		marcaList = marcaList.stream()
				.filter(prato -> prato.getCodigo() != id)
				.collect(Collectors.toList());
	}

}
