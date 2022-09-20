import java.util.Scanner;

public class Game extends Player {

    private static Scanner input= new Scanner(System.in);
    private static int trial=0;
    

    public static void Start_game(){

        Player player_one=new Player();
        Player player_two=new Player();

        Set_names(player_one,player_two);

        while(true){

            game_process(player_one,player_two);

            if(player_one.get_health()>player_two.get_health()) {
                System.out.println("Игрок " + player_one.get_name() + " выиграл игру ");
            }
            else if (player_one.get_health()<player_two.get_health())
                System.out.println("Игрок "+player_two.get_name()+" выиграл игру ");
            else
                System.out.println("Ничья(никто не выиграл)");

            do{
                trial=0;
                try{
                    System.out.println("Чтобы снова играть (введите (0) Для да, (любой другой номер) Для нет)");
                    input= new Scanner(System.in);
                    trial=input.nextInt();
                }catch(Exception error){
                    System.err.println( error +" :Вы ввели неверный вход");
                    trial++;
                }if( trial>=0 || trial<=0){
                    break;
                }
            }
            while(trial!=0);

            if( trial!=0){
                break;
            }
           
            player_one.resetStatus();
            player_two.resetStatus();
            System.out.println("\nИгра была успешно перезапущена\n");
        }
        System.out.println("\nИгра успешно закрылась\n");

    }

    public static void Set_names(Player player_one,Player player_two){

            System.out.println("Назовите игроков в 2 ряда (чтобы в каждом ряду было имя одного игрока)");
            player_one.setName(input.nextLine());
            player_two.setName(input.nextLine());
            if(player_one.get_name().compareTo(player_two.get_name())==0){
                System.err.println("Имена игроков не могут быть одинаковыми");
                Set_names(player_one, player_two);
            }
    }

    public static void input_player_damage(Player player_one){
        do{
            trial=0;
            try {
                input= new Scanner(System.in);
                System.out.println("Введите урон, нанесенный игроком "+player_one.get_name());
                player_one.setPlayer_dmg(input.nextFloat());
            }catch (Exception error){
                System.err.println( error +" :Вы ввели неверный вход,вход должен быть (Float)");
                trial++;
            }
            if(!(player_one.dmg_dealt()>=1 && player_one.dmg_dealt()<=9) && trial==0)
            {
                System.out.println("Урон от игроков должен быть от 1 до 9");
                trial++;
            }
        }while(trial!=0);
    }    
    
    private static void damage_calculation(Player player_one , Player player_two){

        player_one.player_dmg=(player_one.dmg_dealt()*((player_two.dmg_dealt()+1)/10));
        player_two.player_health=(player_two.get_health()- player_one.dmg_dealt());
        }

    public static void game_process(Player player_one, Player player_two) {
        
        while (true)
        {
            input_player_damage(player_one);
            damage_calculation(player_one, player_two);

            if (player_two.get_health()>0) {
                System.out.println("Здоровье человека " + player_two.get_name() + " равно " + player_two.get_health());
            }else break;

            input_player_damage(player_two);
            damage_calculation(player_two, player_one);

            if (player_one.get_health()>0) {
                System.out.println("\nЗдоровье человека " + player_one.get_name() + " равно " + player_one.get_health());
            }else break;
        }
    }
}
