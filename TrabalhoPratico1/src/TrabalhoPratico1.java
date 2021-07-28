import java.util.Scanner;
import java.util.ArrayList;



public class TrabalhoPratico1 
{


	public static void main(String[] args) 
	{
		//clientes
		ArrayList <String> nome_clients = new ArrayList<String> ();
		ArrayList <String> enderecos = new ArrayList<String> ();
		ArrayList <String> telefones = new ArrayList<String> ();
		//produtos
		ArrayList <String> nome_produts = new ArrayList<String> ();
		ArrayList <String> descricoes = new ArrayList<String> ();
		ArrayList <String> valores = new ArrayList<String> ();
		ArrayList <String> porcent_lucros = new ArrayList<String> ();
		ArrayList <Integer> estoques = new ArrayList<Integer> ();
		Scanner ler = new Scanner(System.in);
		
		
		char opcao;
		int quant_client = 0, quant_produt = 0;
		
		//10 clientes
		for(int i = 0; i < 10; i ++)
		{
			nome_clients.add("Cliente" + i);
			enderecos.add("Bairro "+ i +" Rua " + i + " Casa " + i);
			telefones.add ("(" +i+i+ ") " +i+i+i+i+"-"+i+i+i+i);
		}
		
		// 10 tipos de produtos
		for(int i = 0; i < 10 ;i++)
		{
			nome_produts.add("Produto" + i);
			descricoes.add("produto muito bom" + i);
			valores.add("R$" + i + 1 + "0,00");
			porcent_lucros.add(i + 1 + "%");
			estoques.add(i+1);
		}
	
			
		do
		{
			menu ();
			opcao = ler.next().charAt(0);
			
			switch(opcao)
			{
				case '1':
					cadastroCliente(ler, quant_client, nome_clients, enderecos, telefones);
					break;
				case '2':
					buscarCliente (ler, nome_clients, enderecos, telefones);
					break;
				case '3':
					cadastroProduto(ler, quant_produt, nome_produts, descricoes, valores, porcent_lucros, estoques);
					break;
				case '4':
					buscarProduto(ler, nome_produts, descricoes, valores, porcent_lucros, estoques);
					break;
				case '5':
					cadastroVenda( ler,  nome_clients, nome_produts, estoques);
					break;
				case '6':
					mostrarProdutos( nome_produts, descricoes, valores, porcent_lucros, estoques);
					break;
				case '7':
					System.out.println("tchau");
					break;
				default:
					System.out.println("Opção inválida!");
					break;
			}
		}
		while (opcao != '7');
		


	}
	
	
	public static void menu()
	{
		System.out.println("1. Cadastro de novo cliente.");
		System.out.println("2. Busca por cliente.");
		System.out.println("3. Cadastro de novo produto.");
		System.out.println("4. Busca por produto.");
		System.out.println("5. Cadastro de venda.");
		System.out.println("6. Mostrar produtos em estoque.");
		System.out.println("7. Sair.");
		System.out.print("Digite o número correspondente a opção desejada: ");
	}
	
	
	public static void  cadastroCliente(Scanner ler, int quant_client, ArrayList<String> nome_clients, ArrayList<String> enderecos, ArrayList<String> telefones)
	{			
		String nome_client, endereco, telefone;
		
		System.out.println("\n");
		System.out.println("Quantos clientes deseja cadastrar?");
		quant_client = ler.nextInt();
		
		//loop para receber as informações do cliente
		for (int i = 0; i < quant_client; i++)
		{
			ler.nextLine();
			System.out.println("CADASTRO");
			System.out.println("Nome:");
			nome_client = ler.nextLine();
			nome_clients.add(nome_client);
			System.out.println("Endereço:");
			endereco = ler.nextLine();
			enderecos.add(endereco);
			System.out.println("Telefone:");
			telefone = ler.nextLine();
			telefones.add(telefone);
			System.out.println("\n");
			
		}
		
	}

	
	// Método para buscar e alterar informações do cliente
	public static void buscarCliente (Scanner ler, ArrayList<String> nome_clients, ArrayList<String> enderecos, ArrayList<String> telefones)
	{
		

		String achar_client, novo_nome, novo_endereco, novo_telefone;
		char alterar, alterar_info;
		int cont = 0;
		
		System.out.println("\n");
		ler.nextLine();
		System.out.println("Digite o nome do cliente:");
		achar_client = ler.nextLine();
		
		for (int i = 0; i < nome_clients.size() ;i++)
		{
			// Verifica se o cliente está cadastrado
			if (nome_clients.get(i).equalsIgnoreCase(achar_client))
			{
				cont++;
				System.out.println("\n");
				System.out.println("Nome: " + nome_clients.get(i));
				System.out.println("Endereço: " + enderecos.get(i));
				System.out.println("Telefone: " + telefones.get(i));
				
				
				do
				{
					System.out.println("\n");
					System.out.println("Deseja alterar alguma informação?");
					System.out.println("1. Sim");
					System.out.println("2. Não");
					System.out.print("Digite o número correspondente a opção desejada: ");
					System.out.println("\n");
					alterar = ler.next().charAt(0);
				}
				while(alterar != '1' && alterar != '2');
					
		
				   // Alterar informações
					if(alterar == '1')
					{
						
						do
						{
							System.out.println("Qual informação deseja alterar?");
							System.out.println("1. Nome");
							System.out.println("2. Endereço");
							System.out.println("3. Número");
							System.out.println("4. sair");
							System.out.print("Digite o número correspondente a opção desejada: ");
							System.out.println("\n");
							alterar_info = ler.next().charAt(0);
							
							ler.nextLine();
							switch(alterar_info)
							{
								case '1':
									System.out.println("Qual o novo nome?");
									novo_nome = ler.nextLine();
									nome_clients.set(i, novo_nome);
									System.out.println("O nome foi alterado para: "+ novo_nome);
									break;
								case '2':
									System.out.println("Qual o novo endereço?");
									novo_endereco = ler.nextLine();
									enderecos.set(i, novo_endereco);
									System.out.println("O endereço foi alterado para: "+ novo_endereco);
									break;
								case '3':
									System.out.println("Qual o novo número de telefone?");
									novo_telefone = ler.nextLine();
									telefones.set(i, novo_telefone);
									System.out.println("O telefone foi alterado para: "+ novo_telefone);
									break;
								case '4':
									break;
								default:
									System.out.println("Opção incorreta!");
									break;
							}
						}
						while(alterar_info != '4');
					}
					else
						break;	
			}
		}
		
		if(cont == 0)
			System.out.println("cliente não encontrado!");
		
		System.out.println("\n");
		
	}
	
	
	public static void cadastroProduto(Scanner ler, int quant_produt,  ArrayList<String> nome_produts, ArrayList<String> descricoes, ArrayList<String> valores, ArrayList<String> porcent_lucros, ArrayList<Integer> estoques)
	{
		
		String nome_produt, descricao, valor, porcent_lucro;
		int estoque;
		
		System.out.println("\n");
		System.out.println("Quantos produtos deseja cadastrar?");
		quant_produt = ler.nextInt();
		
		ler.nextLine();
		//Loop para cadastro de produto
		for(int i = 0; i < quant_produt; i++)
		{
			System.out.println("Nome:");
			nome_produt = ler.nextLine();
			nome_produts.add(nome_produt);
			System.out.println("Descrição:");
			descricao = ler.nextLine();
			descricoes.add(descricao);
			System.out.println("Valor:");
			valor = ler.nextLine();
			valores.add(valor);
			System.out.println("Porcentagem de lucro:");
			porcent_lucro = ler.nextLine();
			porcent_lucros.add(porcent_lucro);
			System.out.println("estoque:");
			estoque = ler.nextInt();
			estoques.add(estoque);
			System.out.println("\n");
		}
		
	
	}
	
	
	// Método para buscar e alterar informações do produtos
	public static void buscarProduto(Scanner ler, ArrayList<String> nome_produts, ArrayList<String> descricoes, ArrayList<String> valores, ArrayList<String> porcent_lucros, ArrayList<Integer> estoques)
	{

		String achar_produt, novo_descricao, novo_valor, novo_lucro;
		int novo_estoque, cont = 0;
		char alterar, alterar_info;
		
		System.out.println("\n");
		ler.nextLine();		
		System.out.println("Digite o nome do produto que deseja:");
		achar_produt = ler.nextLine();
		
		for (int i = 0; i < nome_produts.size() ;i++)
		{
			// Verifica se o produto está cadastrado
			if (nome_produts.get(i).equalsIgnoreCase(achar_produt))
			{
				cont++;
				System.out.println("\n");
				System.out.println(nome_produts.get(i));
				System.out.println(descricoes.get(i));
				System.out.println(valores.get(i));
				System.out.println(porcent_lucros.get(i));
				System.out.println(estoques.get(i));
			
				do
				{
					System.out.println("\n");
					System.out.println("Deseja alterar alguma informação?");
					System.out.println("1. Sim");
					System.out.println("2. Não");
					System.out.print("Digite o número correspondente a opção desejada: ");
					System.out.println("\n");
					alterar = ler.next().charAt(0);
				}
				while(alterar != '1' && alterar != '2');
				
				// Alterar informações
				if(alterar == '1')
				{
					do
					{
						System.out.println("Qual informação deseja alterar?");
						System.out.println("1. Descrição");
						System.out.println("2. Valor");
						System.out.println("3. Porcentagem de lucro");
						System.out.println("4. Quantidade");
						System.out.println("5. Sair");
						System.out.print("Digite o número correspondente a opção desejada: ");
						alterar_info = ler.next().charAt(0);
						switch(alterar_info)
						{
							case '1':
								System.out.println("Qual a nova dwscrição?");
								novo_descricao = ler.nextLine();
								descricoes.set(i, novo_descricao);
								System.out.println("A descrição foi alterado para: "+ novo_descricao);
								break;
							case '2':
								System.out.println("Qual o novo valor?");
								novo_valor = ler.nextLine();
								valores.set(i, novo_valor);
								System.out.println("O valor foi alterado para: "+ novo_valor);
								break;
							case '3':
								System.out.println("Qual a nova porcentagem de lucro?");
								novo_lucro = ler.nextLine();
								porcent_lucros.set(i, novo_lucro);
								System.out.println("A porcentagem de lucro foi alterado para: "+ novo_lucro);
								break;
							case '4':
								System.out.println("Qual a nova quantidade em estoque?");
								novo_estoque = ler.nextInt();
								estoques.set(i, novo_estoque);
								System.out.println("A quantidade em estoque foi alterado para: "+ novo_estoque);
								break;
							case '5':
								break;
							default:
								System.out.println("Opção incorreta!");
								break;
						}
					}
					while(alterar_info != '5');
				}
				else
					break;
			}
		}
		
		if(cont == 0)
			System.out.println("Produto não encontrado!");
		
		System.out.println("\n");
	}
	
	
	public static void cadastroVenda (Scanner ler, ArrayList<String> nome_clients, ArrayList<String> nome_produts, ArrayList<Integer> estoques)
	{
		String escolhe_client, escolhe_produt;
		int i, venda = 0;
		char sair;
		
		System.out.println("\n");
		for(i = 0; i < nome_clients.size(); i++)
			System.out.println(nome_clients.get(i));
		
		System.out.println("\n");
		ler.nextLine();
		System.out.println("Digite o nome do cliente comprador:");
		escolhe_client = ler.nextLine();
		for(i = 0; i < nome_clients.size(); i++)
		{
			//verifica se o nome do cliente digitado está na lista
			if(nome_clients.get(i).equalsIgnoreCase(escolhe_client))
				System.out.println(nome_clients.get(i));
				
		}
		
		
			
		System.out.println("\n");
		do
		{
			for(i = 0; i < nome_produts.size(); i++)
			{
				System.out.println(nome_produts.get(i));
			}
				
			System.out.println("\n");
			System.out.println("Digite o nome do produto produto comprado:");
			escolhe_produt = ler.nextLine();
			for(i = 0; i < nome_produts.size(); i++)
			{
				//Verifica se o produto digitado está na lista
				if(nome_produts.get(i).equalsIgnoreCase(escolhe_produt))
				{
					System.out.println(nome_produts.get(i));
						
					System.out.println("quantos " + nome_produts.get(i) + " foi comprado por " + nome_clients.get(i) + "?");
					venda = ler.nextInt();
					//Faz a venda de acordo com a quantidade no estoque
					if(estoques.get(i) < venda)
						System.out.println("Quantidade escolhida superior a da contida no estoque!");
					else
						estoques.set(i, (i-venda));
						
				}
			}
			
			System.out.println("\n");
			System.out.println("Continuar cadastrando venda para esse cliente?");
			System.out.println("1. Sim");
			System.out.println("2. não");
			System.out.print("Digite o número correspondente a opção desejada: ");
			sair = ler.next().charAt(0);
		
			}
			while(sair != '2');
			System.out.println("\n");
		
			
	}
	
	
	public static void mostrarProdutos(ArrayList<String> nome_produts, ArrayList<String> descricoes, ArrayList<String> valores, ArrayList<String> porcent_lucros, ArrayList<Integer> estoques)
	{
		
		for(int i = 0; i < nome_produts.size(); i++)
		{
			System.out.println("Produto: " + nome_produts.get(i));
			System.out.println("Descrição: " + descricoes.get(i));
			System.out.println("Valor: " + valores.get(i));
			System.out.println("Procentagem de lucro: " + porcent_lucros.get(i));
			System.out.println("Estoque: " + estoques.get(i));
			System.out.println("\n");
		}
		
	}

	
}
