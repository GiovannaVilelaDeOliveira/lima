package versao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VersaoDao {
	
private static List<Versao> versaoList = new ArrayList<Versao>();
	
	public void cadastrar(Versao pratoInformado) {
		versaoList.add(pratoInformado);
	}
	
	public List<Versao> consultar(){
		return versaoList;
	}
	
	public void excluir(Integer id) {
		versaoList = versaoList.stream()
				.filter(prato -> prato.getCodigo() != id)
				.collect(Collectors.toList());
	}

}
