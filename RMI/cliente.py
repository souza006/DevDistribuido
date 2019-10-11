# importa o pyro
import  Pyro4



nS = Pyro4.locateNS()


uri = nS.lookup('objeto')


objeto = Pyro4.Proxy(uri)

print('Comparador de dois numeros\nPor favor, digite o primeiro número')

# recebe num1
num1= int(input())

# imprime mensagem
print('Por favor, digite o segundo número')

# recebe num 2
num2 = int(input())


print(objeto.similar(num1, num2))
