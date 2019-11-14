import zeep 
from zeep import Client


class Pokemon:
    pass

def novoPokemon():
    poke = Pokemon()
    poke.nome = raw_input('Digite o Nome do Pokemon: ')
    poke.nick = raw_input('Digite o Nick do Pokemon: ')
    poke.numDex = int(raw_input('Digite o numero da Pokedex : '))
    return poke

def main():
	client = Client('http://localhost:8089/pokemon?wsdl')
        print('** Criador de Equipe Pokemon **')
        while True:
            print('\n Escolha uma das seguintes opcoes: ')
            print('i) Inserir Pokemon')
            print('l) Listar Equipe')
            print('0) Encerrar Sessao')
            op = raw_input('> ')
            if op == 'i':
                poke = novoPokemon()
                client.service.insereParty(
                    poke.nome, poke.nick, poke.numDex
                )
            
            elif op == 'l':
                listar = client.service.retornaParty()
                for pokemon in listar:
                    print('#####')
                    print('Numero Dex: ', poke.numDex)
                    print('Nome do Pokemon: ', poke.nome)
                    print('Nick do Pokemon: ', poke.nick)
            elif op == '0':
                break
            else:
                print('Opcao nao definida')

          
if __name__ == '__main__':
    main()
