/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CalculatorAssignment;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.*;

/**
 *
 * @author ahmad
 */
public class CalculatorWithGUI {
    //static variables. global and accessible from anywhere in the code
    static double base;
    static double height;
    static String numberOfClicks = "Zero";
    static String problemType;
    static double quadraticResult1, quadraticResult2, smallerRoot, largerRoot;
    static double aValue, bValue, cValue;
    static double area, volume;
    //can be edited from the functions and other classes
    
    
    public static void main(String[] args) {
        //UserFriendlyCalculator
            /*
                Ahmad Elmasri
                01/03/2017
                Version 0.1
                This is a simple calculator with a GUI and runs one of two 
                calculations with code set in place to catch invalid input
            */
            
        //CODE
                
            //Panel objects
                JFrame calculator = new JFrame("Calculator");
                JPanel panel = new JPanel();//holds all interactive elements
                
            //Button Objects
                JButton submitNameButton = new JButton("Submit");
                JButton startButton = new JButton();
                JButton squarePyramidProblem = new JButton("Square Based "
                    + "Pyramid Area and Volume");
                JButton submitAnswer = new JButton("Submit Answer");
                JButton quadraticFormula = new JButton("Quadratic Roots Calculator");
                
            //Label objects. User output and information
                JLabel intro = new JLabel("Hi there! I'm a simple calculator!");
                JLabel nameAsker= new JLabel("What is your name?");
                JTextField inputField = new JTextField();//Where user puts in answers
                JLabel noNameMessage = new JLabel("Hey there, you don't have a name!");
                JLabel anyMessage = new JLabel();//all purpose messenger
                JLabel formulaViewer = new JLabel();
                JLabel userGuide = new JLabel("Press Submit after typing your name.");
                
                
            //Initializing the GUI's traits and making it visible
                calculator.setVisible(true);
                panel.setLayout(null);//Ensures layout is coder influenced and not default
                calculator.setSize(500,500);
                
            //Setting the size and location of the buttons
                startButton.setBounds(50,50,50,50);
                squarePyramidProblem.setBounds(100,200,300,25);
                submitAnswer.setBounds(100,200,200,25);
                submitNameButton.setBounds(100,200,100,100);
                quadraticFormula.setBounds(100,225,300,25);
                
                
            //Setting size and location of   labels and the textfield   
                intro.setBounds(100,-200,200,500);
                formulaViewer.setBounds(100,75,500,500);
                nameAsker.setBounds(100,-425,200,1000);
                noNameMessage.setBounds(100,-85,200,500);// first 2 are xy, second 2 are size in xy
                inputField.setBounds(100,100,200,25);
                userGuide.setBounds(100,120,300,50);
                
        
        
                //Adds objects to the panel
                calculator.add(panel);
                panel.add(formulaViewer);
                panel.add(inputField);
                panel.add(nameAsker);//makes it interactive w/ users & coders
                panel.add(submitNameButton);
                panel.add(intro);
                panel.add(startButton);
                panel.add(squarePyramidProblem);
                panel.add(submitAnswer);
                panel.add(anyMessage);
                panel.add(noNameMessage);
                panel.add(userGuide);
                panel.add(quadraticFormula);
                
                //sets which objects are seen at the start screen
                squarePyramidProblem.setVisible(false);
                submitAnswer.setVisible(false);
                panel.setVisible(true);
                submitNameButton.setVisible(true);
                intro.setVisible(true);
                nameAsker.setVisible(true);
                inputField.setVisible(true);
                startButton.setVisible(false);//makes it invisible
                noNameMessage.setVisible(false);
                userGuide.setVisible(true);
                quadraticFormula.setVisible(false);
        
//==============================================================================                
           submitNameButton.addActionListener(new ActionListener(){             
          @Override
          public void actionPerformed(java.awt.event.ActionEvent e)  {          
              String name = inputField.getText(); 
              //checks if there is no user input
              if(name.isEmpty()){
                  
                  // No name entered
                  panel.repaint();
                  calculator.repaint();//updates the screen (needs to be done periodically)
                  anyMessage.setVisible(false);
                  noNameMessage.setVisible(true);
                  
                  
              //name entered    
              }else{
                  //Starts the program and opens up the main menu for users
                  nameAsker.setVisible(false);
                  anyMessage.setText("Hello there, " + name +"!" );
                  userGuide.setText("Press the Start button to get started");
                  anyMessage.setBounds(100,-100,500,500);
                  userGuide.setBounds(100,50,300,50);
                  panel.repaint();
                  calculator.repaint();
                  noNameMessage.setVisible(false);
                  anyMessage.setVisible(true);
                  startButton.setText("Start");
                  startButton.setBounds(100,175,100,25);
                  startButton.setVisible(true);
                  submitNameButton.setVisible(false);
                  intro.setVisible(false);
                  
                   }
                                                                     }          
                                                                  });             
           
//==============================================================================           
         //start button is pressed
            startButton.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(java.awt.event.ActionEvent d)  {
              anyMessage.setText("What kind of problem do you want to solve?");
              formulaViewer.setVisible(false);
              submitAnswer.setVisible(false);
              squarePyramidProblem.setVisible(true);
              quadraticFormula.setVisible(true);
              calculator.repaint();
              panel.repaint();
              anyMessage.setVisible(true);
              numberOfClicks = "Zero";
              inputField.setText("");
              userGuide.setText("Press a button to choose your problem");
              //moves on to the main menu and shows options
          }
        });
          
 //=============================================================================         
         //The square pyramid button is pressed
          squarePyramidProblem.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(java.awt.event.ActionEvent d)  {
              anyMessage.setVisible(true);
              submitAnswer.setVisible(true);
              squarePyramidProblem.setVisible(false);
              quadraticFormula.setVisible(false);
              formulaViewer.setText("Volume Formula :(l\u00B2*h)/3" 
                + "\n Area Formula: a\u00B2 + 2(a)*\u221A((a\u00B2/4) + h\u00B2)");
              formulaViewer.setVisible(true);
              anyMessage.setText("What is the base length?");
              calculator.repaint();
              panel.repaint();
              inputField.setText("");
              userGuide.setText("Press the start button at anytime to go back");
              problemType = "Pyramid";//changes the problem type to something else
              
          }
        });
          
//==============================================================================
         //user submits their answer
          submitAnswer.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(java.awt.event.ActionEvent d)  {
              //initializes the format and prepares objects for later use
              NumberFormat decimal = NumberFormat.getNumberInstance(); 
                      decimal.setMinimumFractionDigits( 3 );
                      decimal.setMaximumFractionDigits( 3 );
              calculator.repaint();
              panel.repaint();
              anyMessage.setVisible(true);
              submitAnswer.setVisible(true);
            //The user selected pyramids  
            if(problemType.equals("Pyramid")){
              if(numberOfClicks.equals("Zero")){
                  while(true){
                        try{
                          //gets the values and stores them in the static double
                          base = Double.parseDouble(inputField.getText());
                          inputField.setText("");
                          numberOfClicks = "One";
                          anyMessage.setText("What is the base height?");
                          break;
                          
                        }catch(Exception e){
                            //not a number
                            anyMessage.setText("No or not a number, try again");
                            break;
                                           }
                            }  
                  //Second run to get the height
              }else if(numberOfClicks.equals("One")){
                  while(true){
                    try{
                      height = Double.parseDouble(inputField.getText());
                      volume = (Math.pow(base, 2)*height) / 3;
                      inputField.setText("");
                      area = Math.pow(base, 2) + (2*base)* 
                        ( Math.sqrt( Math.pow(base, 2)/4 + Math.pow(height, 2)) );
                      anyMessage.setText("Your volume is " + decimal.format(volume) 
                        + "m\u00B3" + "  and your area is" + decimal.format(area)
                        + "m\u00B2");
                      break;//everything is formatted and outputted then printed
                  
                 }catch(Exception e){
                     anyMessage.setText("No input or not a number, try again ");
                     break;
                                    }
                                        }
                                                    }
                                               }
            
            
            // if the user selects quadratic it begins the a value collection
            else if(problemType.equals("Quadratic")){
              if(numberOfClicks.equals("Zero")){
                  while(true){
                        try{
                          aValue = Double.parseDouble(inputField.getText());
                          inputField.setText("");
                          numberOfClicks = "One";
                          anyMessage.setText("What is the b value?");
                          break;
                          
                        }catch(Exception e){
                            anyMessage.setText("No input or not a number, try again");
                            break;
                                           }
                            }  
              //second run for the b value
              }else if(numberOfClicks.equals("One")){
                  while(true){
                    try{
                          bValue = Double.parseDouble(inputField.getText());
                          inputField.setText("");
                          numberOfClicks = "Two";
                          anyMessage.setText("What is the c value?");
                          break;
                          
                        }catch(Exception e){
                            anyMessage.setText("No input or not a number, try again");
                            break;
                                           }
                                        }
              }else if(numberOfClicks.equals("Two")){
                  while(true){
                      cValue = Double.parseDouble(inputField.getText());    
                 try{
                      double discriminant = (Math.pow(bValue, 2) - 4*aValue*cValue);
                      
                      if( discriminant > 0){
                         quadraticResult1 = (-bValue + Math.sqrt((Math.pow(bValue, 2)
                                 + (-4* aValue * cValue)))) / (2 * aValue);
                         quadraticResult2 = (-bValue - Math.sqrt((Math.pow(bValue, 2) 
                                 + (-4* aValue * cValue)))) / (2 * aValue);
                         smallerRoot = Math.min(quadraticResult1, quadraticResult2);
                         largerRoot = Math.max(quadraticResult1, quadraticResult2);
                        anyMessage.setText("Root 1 is " + decimal.format(smallerRoot)
                            + "and Root 2 is " + decimal.format(largerRoot) );
                         break;
                         
                    }else if( discriminant == 0){
                         quadraticResult1 = (-bValue + Math.sqrt((Math.pow(bValue, 2)
                                 + (-4* aValue * cValue)))) / (2 * aValue);
                        anyMessage.setText("The only root is " + quadraticResult1);
                         break;
                         
                    }else{
                        anyMessage.setText("Sorry, no real roots. Try again");
                        break;
                      }
                
                 }catch(Exception e){
                     anyMessage.setText("No input or not a number, try again ");
                     break;
                                    }
                                        }
                                                    }
              
              
              
              
              
                                               }
                                                                    }
                                                            });
//==============================================================================
//the quadratic button
quadraticFormula.addActionListener(new ActionListener(){             
          @Override
          public void actionPerformed(java.awt.event.ActionEvent e)  {  
             calculator.repaint();
             panel.repaint();
             anyMessage.setVisible(true);
             submitAnswer.setVisible(true);
             quadraticFormula.setVisible(false);
             squarePyramidProblem.setVisible(false);
             formulaViewer.setText("Quadratic Formula :-b + " 
               + "\u221A(b\u00B2 + 4(a)(c))/2");
             formulaViewer.setVisible(true);
             anyMessage.setText("What is the a value?");
             inputField.setText("");
             userGuide.setText("Press the start button at anytime to go back");
             calculator.repaint();
             panel.repaint();
             problemType = "Quadratic";//changes to quadratic mode which has other roles

                                                                     }          
                                                        });           
        
        
        
        

        
    }
    
                      }
        

