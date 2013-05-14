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
		float aux;
		
		boolean debug = true;
		int n,i,count,j;
		Scanner in = new Scanner(System.in);
		
		//Entrada do tamanho da matriz
		System.out.println();
		System.out.println("*******  Calculo de Algebra Linear ********");
		System.out.println();
		System.out.print("Entre com o tamamnho da matriz: ");
		n = in.nextInt();
				
		
		//Entrada dos valores do sistema
		for(i=0; i<n; i++){
			for (j=0; j<n; j++){
				System.out.print("Entre com o valor da matrix [" + i + "][" + j + "] :");
				matrix[i][j] = in.nextFloat();
				System.out.println();
			}
			
			System.out.print("Entre com o valor de b: ");
			b[i] = in.nextFloat();
			System.out.println();
		}
		
		
		//ImpressÃ£o da Matriz
		System.out.println();
		System.out.println();
		System.out.println("A matrix ORIGINAL eh:");
		System.out.println();
		for(i=0; i<n; i++){
			for(j=0; j<n; j++){
				System.out.print(" " +String.format("%8s", matrix[i][j])+"(X"+(i+1)+")");
			}
			
			System.out.print(" = "+String.format("%3s", b[i]));
			System.out.println();
		}
		System.out.println();
		
		//Eliminação de GAUSS
		for(i=0; i<(n-1); i++) {
			if(debug) System.out.println("i:"+i);
			for(j=(i+1); j<n; j++){
				if(debug) System.out.println("j:"+i);
				ratio = matrix[j][i] / matrix[i][i];
				if(debug) System.out.println("ratio: "+matrix[j][i]+"/"+matrix[i][i]+" = "+ratio);
				for(count =i; count<n; count++){
					aux = matrix[j][count];
					matrix[j][count] = matrix[j][count] - (ratio * matrix[i][count]); 
					if(debug) System.out.println("matrix["+j+"]["+count+"] = matrix["+j+"]["+count+"] - (ratio x "+"matrix["+i+"]["+count+"]) = "+aux+" - ("+ratio+" x "+matrix[i][count]+") = "+matrix[j][count]);
				}
				aux = b[j];
				b[j] = b[j] - (ratio * b[i]);
				if(debug) System.out.println("b["+j+"] = b["+j+"] - (ratio * b["+i+"]) =  "+aux+" - ("+ratio+" x "+b[i]+") = "+b[j]);
				if(debug) System.out.println();
			}
		}
		
				
		//ImpressÃ£o da Matriz
		System.out.println();
		System.out.println();
		System.out.println(" *** A matrix ESCALONADA eh: ***");
		System.out.println();
		for(i=0; i<n; i++){
			for(j=0; j<n; j++){
				System.out.print(" " +String.format("%8s", matrix[i][j])+"(X"+(i+1)+")");
			}
			System.out.print(" = "+String.format("%3s", b[i]));
			System.out.println();
		}
		System.out.println();
		
		//Processo de Substituição Retroativa
		
		
		x[n-1] = b[n-1] / matrix[n-1][n-1];
		
		if(debug){
			System.out.println("*** Substituição retroativa ***");
		}
		for(i=(n-2); i>=0; i--){
			if(debug) System.out.println("i: "+i);
			temp = b[i];
			if(debug) System.out.println("temp: "+temp);
			for(j=(i+1); j<n; j++){
				if(debug) System.out.println("temp = "+b[i]+" - ("+matrix[i][j]+" x "+x[j]+")");
				temp = temp - (matrix[i][j] * x[j]);
			}
			if(debug) System.out.println("x["+i+"] = "+temp+" / "+matrix[i][i]);
			if(debug) System.out.println();
			x[i] = temp / matrix[i][i];
		}
		
		
		//ImpressÃ£o da RESPOSTA
		System.out.println();
		System.out.println();
		System.out.println("A SOLUCAO da matrix eh:");
		System.out.println();
		for(i=0; i<n; i++){
			System.out.println("X" + i + " = " + x[i]);
		}
		
		in.close();
		
	}

}
