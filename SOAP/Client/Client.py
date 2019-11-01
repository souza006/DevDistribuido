from zeep import Client

class Pokemon
    pass

def novoPokemon():
    poke = Pokemon()
    poke.nome = input('Digite o Nome do Pokémon: ')
    poke.nick = input('Digite o Nick do Pokémon: ')
    poke.numDex = int(input('Digite o número da Pokedex : '))
    return poke

    def main():
        clien = Client('http://localhost:8001/pokedex')
        print('** Criador de Equipe Pokémon **')
        while True:
            print('\n Escolha uma das seguintes opções: ')
            print('1) Inserir Pokémon')
            print('2) Listar Equipe')
            print('0) Encerrar Sessão')
            op = input('> ')
            if op == '1':
                pokemon = novoPokemon()
                client.service.inserePokemon(
                    poke.nome, poke.nick, poke.numDex
                )
            
            elif op == '2':
                listar = client.service.retornaPokemon()
                for pokemon in listar:
                    print('#####')
                    print('Numero Dex: ', pokemon.numDex)
                    print('Nome do Pokemon: ', pokemon.nome)
                    print('Nick do Pokemon: ', pokemon.nick)
            elif op == '0':
                break
            else:
                print('Operação não definida')

            