import java.net.URL;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

public class ClienteRPC {

	//DEFINE A URL DO SERVIDOR
    private static final String URL_SERVIDOR = "http://localhost:8185"; 
    private XmlRpcClient cliente;
	
    public ClienteRPC() {
		try {
			//configura o cliente para que ele possa se conectar ao servidor
			XmlRpcClientConfigImpl configuracaoCliente = new XmlRpcClientConfigImpl();
            configuracaoCliente.setServerURL(new URL(URL_SERVIDOR));
			//seta a configuração no cliente
            cliente = new XmlRpcClient();
            cliente.setConfig(configuracaoCliente);
        } catch (Exception exception) {
            System.err.println("JavaServer: " + exception);
        }
    }

    public int multiplicar(int x, int y) throws Exception {
        Object[] parametros = new Object[]{new Integer(x), new Integer(y)};
        Integer resultado = (Integer) cliente.execute("Calculo da multiplicacao", parametros);
        return resultado;
    }

    public static void main(String[] args) throws Exception {
        ClienteRPC x = new ClienteRPC();
        System.out.println("O Resultado da multiplicacao: " + x.multiplicar(1, 2));
    }

}







