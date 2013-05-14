import java.util.Scanner;


public class EliminacaoGauss {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		float matrix[][] = new float[16][16];
		float b[] = new float [16];
		float x[] = new float [16];
		float ratio, temp;
		int n,i,count,j;
		Scanner in = new Scanner(System.in);
		
		//Entrada do tamanho da matriz
		System.out.println();
		System.out.println("*******  Calculo de Algebra Linear ********");
		System.out.println();
		System.out.print("Entre com o tamamnho da matriz: ");
		n = in.nextInt();
				
		
		//Entrada dos valores do sistema
		for(i=0; i<n; i++)
		{
			for (j=0; j<n; j++)
			{
				System.out.print("Entre com o valor da matrix [" + i + "][" + j + "] :");
				matrix[i][j] = in.nextFloat();
				System.out.println();
			}
			
			System.out.print("Entre com o valor de b: ");
			b[i] = in.nextFloat();
			System.out.println();
		}
		
		
		//Impressão da Matriz
		System.out.println();
		System.out.println();
		System.out.println("A matrix ORIGINAL eh:");
		System.out.println();
		for(i=0; i<n; i++)
		{
			for(j=0; j<n; j++)
			{
				System.out.print("   " + matrix[i][j]);
			}
			
			System.out.print("       " + b[i]);
			System.out.println();
		}
		
		
		//Elimina��o de GAUSS
		for(i=0; i<(n-1); i++)
		{
			for(j=(i+1); j<n; j++)
			{
				ratio = matrix[j][i] / matrix[i][i];
				
				for(count =i; count<n; count++)
				{
					matrix[j][count] = matrix[j][count] - (ratio * matrix[i][count]); 
				}
				
				b[j] = b[j] - (ratio * b[i]);
			}
		}
		
				
		//Impressão da Matriz
		System.out.println();
		System.out.println();
		System.out.println("A matrix ESCALONADA eh:");
		System.out.println();
		for(i=0; i<n; i++)
		{
			for(j=0; j<n; j++)
			{
				System.out.print("   " + matrix[i][j]);
			}
			
			System.out.print("       " + b[i]);
			System.out.println();
		}
		
		
		//Processo de Substituição Retroativa
		x[n-1] = b[n-1] / matrix[n-1][n-1];
		for(i=(n-2); i>=0; i--)
		{
			temp = b[i];
			
			for(j=(i+1); j<n; j++)
			{
				temp = temp - (matrix[i][j] * x[j]);
			}
			
			x[i] = temp / matrix[i][i];
		}
		
		
		//Impressão da RESPOSTA
		System.out.println();
		System.out.println();
		System.out.println("A SOLUCAO da matrix eh:");
		System.out.println();
		for(i=0; i<n; i++)
		{
			System.out.println("X" + i + " = " + x[i]);
		}
		
		in.close();
		
	}

}
