import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 */

/**
 * @author Ananta Bhatt
 * 
 * Description: Code for Permutation Cipher
 *
 */

public class PermutationCipher {
	
	//Initialising arrays
	
static char[] enArray=new char[6];
static char[] decryptArray=new char[6];

//Setting block value
static int m=6;
static int[] initialarray= {0,1,2,3,4,5};
static int [] key;
static String cp;



static int[] shuffleArray(int[] array)
{
	//Random function
  Random rnd = ThreadLocalRandom.current();
  for (int i =0; i<array.length; i++)
  {
    int index = rnd.nextInt(i + 1);
    
 // Swapping
    int a = array[index];
   array[index] = array[i];
   array[i] = a;
  }
  return array;
}

public static String encrypt(String plainText, int [] key )
{
	//Split array into blocks of number m
	
String[] block=plainText.split("(?<=\\G.{6})");

//calculating the number of blocks
int blockNumber= block.length;

//Taking last block 
String last= block[blockNumber-1];

//Padding last block
if (last.length()< 6)
{
	for(int i=last.length();i<6;i++)
	{
		last += '*';
	}
}

block[blockNumber-1]=last;
String encryptArray="" ;


for(int i=0;i <block.length;i++)
{   
	//Converting block to string array
	String blockString= block[i].toString();
	
	//Converting to char array
	char [] b= blockString.toCharArray();
	int j,k;
	
	//Pointers at block and key
	for(j=0,k=0;j<blockString.length()&&k<key.length;j++,k++)
	{
		
		int position= key[k];
		enArray[position]=b[j];
	}	
	
    for(int x=0;x<enArray.length;x++)
    {
    	encryptArray +=enArray[x];
    	
    }
	}	
return encryptArray;
}


public static void decrypt(String cipherText, int [] invkey )
{

     //Split Ciphertext
     String[] ip=cipherText.split("(?<=\\G.{6})");


for(int c=0;c <ip.length;c++)
{   
	//Convert into String Array
	String block= ip[c].toString();
	
	//Convert into Character Array
	char [] b= block.toCharArray();
	int l,k;
	
	//Pointers at block and inverse key
	for(l=0,k=0;l<block.length() && k<invkey.length;l++,k++)
	{
		
		int pos= invkey[k];
		decryptArray[pos]=b[l];
	}
	
	//Removing Padding
	for (int i=0; i<decryptArray.length;i++)
	{
		if(decryptArray[i]!='*')
		System.out.print(decryptArray[i]);
	}
	}
	
}



public static int[] inverseKey(int [] key)
{
	int [] inv=new int[6]; 
	int pos;
for(int i=0,j=0; i<key.length && j<key.length;i++,j++)
	{
	 
	pos = key[i];
    inv [pos]= j;   
}
System.out.println("The inverse key is :" );
for (int l = 0; l < inv.length; l++)
{
  System.out.print(inv[l]+" ");
}
return inv;
}

public static void main(String args[])
{
	// call for Shuffle the array 
	key= shuffleArray(initialarray);
	System.out.println("The Random permutated Key is:" );
    for (int i = 0; i < key.length; i++)
    {
      System.out.print(key[i]+" ");
    }
    System.out.println();
    System.out.println();
	String plaintext;
	
    Scanner x= new Scanner(System.in);
                System.out.println("Enter the PlainText:");
                plaintext = x.nextLine();
                String ciphertext= encrypt(plaintext, key);
                System.out.println("\nThe cipher for this program is: " + ciphertext);
                System.out.println();
                int[] keyInverse;
            	keyInverse =inverseKey(key);
            	System.out.println();
            	System.out.println("\nDecrypted message for this program is: ");
                decrypt(ciphertext, keyInverse);
             
          x.close(); 
        }
    }

