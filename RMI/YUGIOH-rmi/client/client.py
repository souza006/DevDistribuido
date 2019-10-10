import sys
from digimon import Digimon = Carta
from digiescolhido import Digiescolhido  = Duelista ; digivice = deck
import Pyro4
import Pyro4.util

sys.excepthook = Pyro4.util.excepthook

def main():
    # test setup
    storage = Pyro4.Proxy("PYRONAME:deck.storage")
    cod = 2
    yugi = Duelista(1, "TK")
    buster = Carta("Buster", "Monstro")
    magician = Digimon("Magician", "Mago")
    tk.scan(patamon, storage)
    tk.scan(angemon, storage)
    mestres = []
    mestres.append(tk)
    mestres_nome = []
    mestres_nome.append("TK")
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
                    menu2 = "[1]digiSave\n[2]digiOut\n[3]digiLista\n[4]DigiScans\n[0]sair"
                    print(menu2)
                    op2 = input(": ")
                    if op2 == "1":
                        digimon = input("Nome do Digimon: ")
                        find = False
                        for d in mestre.digimons:
                            if d.getName() == digimon:
                                find = True
                                storage.store(mestre.getCod(), digimon)
                                mestre.digimons.remove(d)
                                print("Digimon Salvo :D ")
                                break
                        if not find:
                            print("Digimon não encontrado")

                    elif op2 == "2":
                        digimon = input("Nome do digimon: ")
                        find = False
                        stored_digimons = storage.listStoredDigimons(mestre.getCod())
                        for d in stored_digimons:
                            if d == digimon:
                                find = True
                                storage.retrieve(mestre.getCod(), digimon)
                                mestre.digimons.append(digimon)
                                print("Digimon retirado")
                                break
                        if not find:
                            print("Digimon não encontrado")
                    elif op2 == "3":
                        for d in storage.listStoredDigimons(mestre.getCod()):
                            print(d)
                    elif op2 == "4":
                        for d in mestre.digimons:
                            if type(d) == str:
                                print(d)
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
            mestre = Digiescolhido(cod, nome)
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
