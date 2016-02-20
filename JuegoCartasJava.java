import java.io.*;
import java.util.*;
import java.lang.*;


public class JuegoCartasJava{

	ArrayList<Carta> baraja = new ArrayList<Carta>();
	ArrayList<Carta> cartasJugadas = new ArrayList<Carta>();

	public static void main(String[] args){
		//System.out.println(args.length);
		if(args.length>0){
			try{
				int i=0;
				int numIntentos = Integer.parseInt(args[0]);
				JuegoCartasJava j = new JuegoCartasJava();
				for(int k=0; k<numIntentos; k++){
					if(j.JuegoCartasJava()){
						i++;
					}
					if(i==1000000|| i==3000000|| i==5000000|| i==7000000|| i==9000000){
						System.out.println(i);
					}
				}
				System.out.println("El numero de victorias en "+numIntentos+" intentos es: "+i);
				System.out.println("El numero de derrotas: "+(numIntentos-i));
				if(i>0)
					System.out.println("En esta simulacion sale una media de 1 victoria cada "+(numIntentos/i)+" intentos");
				else
					System.out.println("En esta simulacion sale una media de 0 victoria en "+numIntentos+" intentos");
			}catch(Exception e){
				e.printStackTrace();
			}
		}else{
			System.out.println("Wrong number of arguments");
			System.out.println("Use: JuegoCartasJava tryings");
		}
	}


	public boolean JuegoCartasJava(){
		//System.out.println("JUEGO DE CARTAS JPV");
		//System.out.println("Creando baraja...");
		String[] palos = {"espadas", "oros", "copas", "vastos"};
		String[] numeros = {"A", "2", "3", "4", "5", "6", "7", "S", "C", "R"};
		//String[] numeros = {"A", "2", "3"};
		
		baraja = new ArrayList<Carta>();
		cartasJugadas = new ArrayList<Carta>();
		for(String i: palos){
			for(String j: numeros){
				Carta carta = new Carta(i, j);
				baraja.add(carta);
			}
		}	
		try{	
			Thread.sleep(3);
		}catch(Exception e){ e.printStackTrace();}

		/*System.out.println("Mostrando baraja creada...");
		for(Carta c: baraja){
			System.out.println(c.numero+" "+c.palo);
		}

		System.out.println("\nBarajando cartas...");
		try{	
			Thread.sleep(3);
		}catch(Exception e){ e.printStackTrace();}*/
			
		long seed = System.nanoTime();
		Collections.shuffle(baraja, new Random(seed));
		/*for(Carta c: baraja){
			System.out.println(c.numero+" "+c.palo);
		}*/


		    //algoritmo del juego
	    //System.out.println("\nEmpieza el juego...");
	    for(int i=0; i<baraja.size(); i++){
	    	cartasJugadas.add(baraja.get(i));
	    	while(comprobarTablero());
	    }

	    //Mostramos si se ha ganado:
	    if(cartasJugadas.size()<3){
	    	//System.out.println("ENHORABUENA, HA GANADO LA PARTIDA!");
	    	return true;
	    }else{
	    	//System.out.println("DERROTA");
	    	return false;
	    }
		
	}

	public boolean comprobarTablero(){
		//bucle desde el tercer elemento 
		for(int i=0; i<cartasJugadas.size(); i++){
			if(i>=2){
				//System.out.println(baraja.get(i).numero+" "+baraja.get(i).palo);
				if(cartasJugadas.get(i).getPalo().equals(cartasJugadas.get(i-2).getPalo()) || cartasJugadas.get(i).getNumero().equals(cartasJugadas.get(i-2).getNumero())){
					for(int j=i-2; j<cartasJugadas.size()-1; j++){
						cartasJugadas.set(j, cartasJugadas.get(j+1));
					}
					cartasJugadas.remove(cartasJugadas.size()-1);
					/*System.out.println("El tamaño del array es de: "+cartasJugadas.size());
					for(Carta c: cartasJugadas){
						System.out.println(c.numero+" "+c.palo);
					}
					System.out.println("\n\t----------------\n");*/
					return true;
				}
			}
		}
		return false;
	}
}


class Carta{
	String palo;
	String numero;
	//constructor
	public Carta(String p, String n){
		palo=p;
		numero=n;
	}
	public String getPalo(){
		return palo;
	}
	public String getNumero(){
		return numero;
	}
}