# permutationCipher
Software: Eclipse Java Oxygen, Version: Oxygen.2 Release (4.7.2)
Programming Language: Java Language 
Compiler: jdk-9.0.4
Steps 1 : Initialisation
- Initialise block size(m)=6, array value={0,1,2,3,4,5}. Take input plaintext from the user
Step2: Shuffle Array Method- Call ShuffleArray Method
-Generate random permutated key using Shuffle Array Method. Further, in this substitution cipher program we need a permutated key, so we have used the ThreadLocalRandom.current() to generate random values from the assigned alphabet array defined earlier.
-This random generated value is swapped with the value positioned at the end of the array. The step is repeated till the first element is swapped.  Accordingly, the permutated key is generated.
Step 3: Encryption- Call Encryption Method. 
-This method takes plaintext and key as the parameters. Further, in this method we divide the plaintext according to the block size(m=6) using plainText.split("(?<=\\G.{6})") and store it as a string array.
-Padding: We take the last split block and store it as a string. Further, we calculate the length of the elements in the last block using last.length. Further, we pad the plaintext if the length of the last block is less than 6. Using stored last block length, we append the last block elements with ‘*’ 
-The blocks are converted to a character array. Further, we take two pointers- first pointer(j) pointing at the elements of the block and the second pointer(k) pointing at the elements of the key. We store the position of the kth element of the key. The element at the jth position of the block is then stored at the same position of the kth element of the key in the encrypted array. Where the pointers are from 0 to the key length
-Return this encrypted Array
Step 4: Key Inverse- Call key Inverse Method
-Using for loop the key is inverse with the encrypted key.
Step 5: Decryption- Call Decryption Method
-Split the ciphertext according to the block size(m=6) using cipherText.split("(?<=\\G.{6})")
-Padding: The blocks are converted to char array. Further, we take two pointers- first pointer(k) pointing at the elements of the inverse of key and the second pointer(l) pointing at the elements of the block. We store the position of the kth element of the inverse key. The element at the lth position of the block is then stored at the same position of the kth element of the inverse key in the decrypted array. Where the pointers are from 0 to the inverse key length.
-Remove the padded ‘*’
-Return this decrypted Array
