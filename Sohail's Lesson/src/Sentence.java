/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ali
 */

  public class Sentence
   {
      
       public static void main(String[] args)
      {
         System.out.println("PALINDROME TESTER");
         Sentence s = new Sentence( "\"Hello there!\" she said." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
         s = new Sentence( "A Santa lived as a devil at NASA." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
        
      
         s = new Sentence( "Flo, gin is a sin! I golf." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
         
      
         s = new Sentence( "Eva, can I stab bats in a cave?" );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();
      
         s = new Sentence( "Madam, I'm Adam." );
         System.out.println( s.getSentence() );
         System.out.println( s.getNumWords() );
         System.out.println( s.isPalindrome() );
         System.out.println();

      }
   

     private static String punct = ".,?!:;\"/'(){}$<>@#%^&*";
     private String mySentence;
     private boolean isPalindrome = false; 
     private int myNumWords;
      
      public Sentence( String str )
      { 
         mySentence = str; 
			String[] space = str.split(" "); 
			myNumWords = space.length; 
      }
      
      public int getNumWords()
      {  
         return myNumWords;  
      }
      
      public String getSentence()
      {
         return mySentence; 
      }
      
 
      public boolean isPalindrome()
      { 
			String s = mySentence; 
			s = scrub(s); 
			if(s.isEmpty())
			{
				System.out.println("You entered an empty string or just punctuation marks!"); 
				return false; 
			}
			return isPalindrome(s, 0, s.length()); 
      }

      private static boolean isPalindrome( String str, int start, int end )
      {
         if(str.length() == 0 || str.length() == 1)
				return true;
				 
			else if(str.charAt(start) != str.charAt(end-1))
				return false; 
			
			str = str.substring(start + 1, end - 1); 
			return isPalindrome(str, 0, str.length());
			  
		}
      
      private static String removeBlanks( String s )
      {  
         s = s.replace(" ", "");
			return s;  
      }
      

      private static String lowerCase( String s )
      {  
         s = s.toLowerCase(); 
			return s; 
      }
      

      private static String removePunctuation( String s )
      { 
         String word = s; 
         for(int i = 0; i < punct.length(); i++)
         {
            for(int w = 0; w < word.length(); w++)
            {
               if(punct.charAt(i) == word.charAt(w))
                  word = word.replace(word.charAt(w)+"", ""); 
            }
         } 
         return word; 
     
      }
		//Returns copy of lowercase String s with all punctuation and spaces removed.
		//Postcondition: Returned string contains just one word. 
        private static String scrub(String s)
	{
            s = lowerCase(s); 
            s = removeBlanks(s); 
            s = removePunctuation(s);
            return s; 
	}

  }