/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "teste.h"

/*valores*/
int x;
int z; 
int op; 

void
simp_prog_1(char *host, int x, int z, int op)
{
	CLIENT *clnt;
	int  *result_1;
	operands  soma_1_arg;
	int  *result_2;
	operands  subtracao_1_arg;
	int  *result_3;
	operands  divisao_1_arg;
	int  *result_4;
	operands  multiplicacao_1_arg;
	int  *result_5;
	operands  maior_1_arg;
	int  *result_6;
	operands  menor_1_arg;
	int  *result_7;
	operands  porcentagem_1_arg;

#ifndef	DEBUG
	clnt = clnt_create (host, SIMP_PROG, SIMP_VERSION, "udp");
	if (clnt == NULL) {
		clnt_pcreateerror (host);
		exit (1);
	}
#endif	/* DEBUG */
	if (op==1){	
		soma_1_arg.x=x;
		soma_1_arg.z=z;
	 	result_1 = soma_1(&soma_1_arg, clnt);
		printf("O resultado da soma é: %d\n", *result_1);
	} else if (op==2){
		subtracao_1_arg.x=x;
		subtracao_1_arg.z=z;
		result_2 = subtracao_1(&subtracao_1_arg, clnt);
		printf ("O resultado da subtração é: %d\n", *result_2);
	} else if (op==3){
		multiplicacao_1_arg.x=x;
		multiplicacao_1_arg.z=z;
		result_3 = multiplicacao_1(&multiplicacao_1_arg, clnt);
		printf("O resultado da multiplicação é: %d\n", *result_3);
	}else if (op==4){
		divisao_1_arg.x=x;
		divisao_1_arg.z=z;
		result_4 = divisao_1(&divisao_1_arg, clnt);
		printf("O resultado da divisão é: %d\n", *result_4);
	} else if (op==5){
		maior_1_arg.x=x;
		maior_1_arg.z=z;
		result_5 = maior_1(&maior_1_arg, clnt);
		printf("O maior valor é: %d\n", *result_5);
	} else if (op==6){
		menor_1_arg.x=x;
		menor_1_arg.z=z;
		result_6 = menor_1(&menor_1_arg, clnt);
		printf("O menor valor é: %d\n", *result_6);
	} else if (op==7){
		porcentagem_1_arg.x=x;
		porcentagem_1_arg.z=z;
		result_7 = porcentagem_1(&porcentagem_1_arg, clnt);
		printf("A porcentagem é: %d\n", *result_7);
	}	

#ifndef	DEBUG
	clnt_destroy (clnt);
#endif	 /* DEBUG */
}


int
main (int argc, char *argv[])
{
	char *host;

	if (argc < 2) {
		printf ("usage: %s server_host\n", argv[0]);
		exit (1);
	}
	host = argv[1];
	printf("Bem-vindo! Qual operação deseja realizar?\n");
	printf("(1) - Soma\n");
	printf("(2) - Subtração\n");
	printf("(3) - Multiplicação\n");
	printf("(4) - Divisão\n");
	printf("(5) - Maior \n");
	printf("(6) - Menor \n");
	printf("(7) - Porcentagem \n");
	scanf ("%d", &op);
	
	printf("Digite o primeiro valor: \n");
	scanf ("%d", &x);
	
	printf("Digite o segundo valor: \n");
	scanf ("%d", &z); 
	
	simp_prog_1(host,  x, z, op);
	/*simp_prog_1 (host, argv);*/
exit (0);
}