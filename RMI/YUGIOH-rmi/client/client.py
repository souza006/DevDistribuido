import sys
from carta import Carta
from duelista import Duelista
import Pyro4
import Pyro4.util

sys.excepthook = Pyro4.util.excepthook

def main():
    # test setup
    storage = Pyro4.Proxy("PYRONAME:deck.storage")
    cod = 2
    yugi = Duelista(1, "Yugi")
    buster = Carta("Buster", "Monstro")
    magician = Carta("Magician", "Mago")
    yugi.save(patamon, storage)
    yugi.scan(angemon, storage)
    mestres = []
    mestres.append(yugi)
    mestres_nome = []
    mestres_nome.append("Yugi")
    menu = "[1]usuario exitente\n[2]novo usuario\n[0]sair"

    run = True
    while run:
        print(menu)
        op = input(": ")
        if op == "1":
            nome = input("Digite seu nome:")
            if nome in mestres_nome:
                mestre = None
                for m in mestres:
                    if nome == m.name:
                        mestre = m
                        break
                run2 = True
                while run2:
                    menu2 = "[1]Inserir Carta\n[2]Remover Carta\n[3]Listar Cartas\n[4]Mostrar Carta\n[0]sair"
                    print(menu2)
                    op2 = input(": ")
                    if op2 == "1":
                        carta = input("Nome do Carta: ")
                        find = False
                        for c in mestre.cartas:
                            if d.getName() == carta:
                                find = True
                                storage.store(mestre.getCod(), carta)
                                mestre.cartas.remove(d)
                                print("Carta Salvo :D ")
                                break
                        if not find:
                            print("Carta não encontrado")

                    elif op2 == "2":
                        carta = input("Nome do Carta: ")
                        find = False
                        stored_cartas = storage.listStoredCartas(mestre.getCod())
                        for c in stored_cartas:
                            if c == carta:
                                find = True
                                storage.retrieve(mestre.getCod(), carta)
                                mestre.cartas.append(carta)
                                print("Carta retirada")
                                break
                        if not find:
                            print("Carta não encontrada")
                    elif op2 == "3":
                        for d in storage.listStoredCartas(mestre.getCod()):
                            print(c)
                    elif op2 == "4":
                        for c in mestre.cartas:
                            if type(c) == str:
                                print(c)
                            else:
                                print(d.getName())
                    elif op2 == "0":
                        run2 = False
                    else:
                        print("Opção inválida")
            else:
                print("Usuario nao encontrado")

        elif op == "2":
            nome = input("Digite seu nome:")
            mestre = Duelista(cod, nome)
            mestres.append(mestre)
            mestres_nome.append(mestre.name)
            cod += 1
            print("Usuario criado!")
        elif op == "0":
            run = False
        else:
            print("Opção inválida")

if __name__ == "__main__":
    main()
