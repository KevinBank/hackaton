import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        Farm farm = new Farm();
        Forest forest = new Forest();
        Windmills windmills = new Windmills();
        Solarpanel solarpanel = new Solarpanel();
        Factory factory = new Factory();
        Oilrig oilrig = new Oilrig();
        Airpurifier airpurifier = new Airpurifier();
        Nuclear2 nuclear2 = new Nuclear2();
        Nuclear3 nuclear3 = new Nuclear3();

        Scanner scan = new Scanner(System.in);

        int pollution = 0;
        int pollutionTurn = 0;
        int pollutionStandard = 500;
        int money = 0;
        int moneyTurn = 0;
        int moneyStandard = 250;
        int turn = 0;

        boolean runGame = true;

        String[] build = {"Farm", "Forest", "Windmills", "Solarpanel", "Factory", "Oilrig", "Airpurifier", "Nuclear2", "Nuclear3",};
        String[] ascii = {
                //0 farm
                "                         _.-^-._    .--.\n" +
                "                      .-'   _   '-. |__|\n" +
                "                     /     |_|     \\|  |\n" +
                "                    /               \\  |\n" +
                "                   /|     _____     |\\ |\n" +
                "                    |    |==|==|    |  |\n" +
                "|---|---|---|---|---|    |--|--|    |  |\n" +
                "|---|---|---|---|---|    |==|==|    |  |\n" +
                "^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^",
                //1 forest
                "            ,@@@@@@@,\n" +
                "    ,,,.   ,@@@@@@/@@,  .oo8888o.\n" +
                " ,&%%&%&&%,@@@@@/@@@@@@,8888\\88/8o\n" +
                ",%&\\%&&%&&%,@@@\\@@@/@@@88\\88888/88'\n" +
                "%&&%&%&/%&&%@@\\@@/ /@@@88888\\88888'\n" +
                "%&&%/ %&%%&&@@\\ V /@@' `88\\8 `/88'\n" +
                "`&%\\ ` /%&'    |.|        \\ '|8'\n" +
                "    |o|        | |         | |\n" +
                "    |.|        | |         | |\n" +
                " \\\\/ ._\\//_/__/  ,\\_//__\\\\/.  \\_//__/_\n",
                //2 windmill
                "                                        __\n" +
                "                 ,-_                  (`  ).\n" +
                "                 |-_'-,              (     ).\n" +
                "                 |-_'-'           _(        '`.\n" +
                "        _        |-_'/        .=(`(      .     )\n" +
                "       /;-,_     |-_'        (     (.__.:-`-_.'\n" +
                "      /-.-;,-,___|'          `(       ) )\n" +
                "     /;-;-;-;_;_/|\\_ _ _ _ _   ` __.:'   )\n" +
                "        x_( __`|_P_|`-;-;-;,|        `--'\n" +
                "        |\\ \\    _||   `-;-;-'\n" +
                "        | \\`   -_|.      '-'\n" +
                "        | /   /-_| `\n" +
                "        |/   ,'-_|  \\\n" +
                "        /____|'-_|___\\\n" +
                " _..,____]__|_\\-_'|_[___,.._\n" +
                "'                          ``'--,..,.   ",
                //3 solarpanels
                "     ___________       ___________       ___________       ___________  \n" +
                "    /   /  /   /      /   /  /   /      /   /  /   /      /   /  /   /  \n" +
                "   /---/--/---/      /---/--/---/      /---/--/---/      /---/--/---/   \n" +
                "  /---/--/---/|     /---/--/---/|     /---/--/---/|     /---/--/---/|   \n" +
                " /---/--/---/ |    /---/--/---/ |    /---/--/---/ |    /---/--/---/ |   \n" +
                "/___/__/___/| |   /___/__/___/| |   /___/__/___/| |   /___/__/___/| |   ",
                //4 factory
                "                 __  . .* ,\n" +
                "               ~#@#%(\" .,$ @\n" +
                "              .\"^ ';\"\n" +
                "             ..\n" +
                "            ;. :                                   . .\n" +
                "            ;==:                     ,,   ,.@#(&*.;'\n" +
                "            ;. :                   .;#$% & ^^&\n" +
                "            ;==:                   &  ......\n" +
                "            ;. :                   ,,;      :\n" +
                "            ;==:  ._______.       ;  ;      :\n" +
                "            ;. :  ;    ###:__.    ;  ;      :\n" +
                "___________.'  `._;       :  :__.' .'        `.__________________",
                //5 oilrig
                "              /\\\n" +
                "             /\\/\\\n" +
                "            _|/\\|_\n" +
                "           |______|\n" +
                "            |\\/\\/|\n" +
                "           \\|/\\/\\|   .''`/:\n" +
                "   :\\''.    \\`'. |  ||  /  :\n" +
                "   : \\ ||   |\\ |||  || /    o\n" +
                "   j _\\||__/__\\||_\\_||/___\n" +
                "     |___________________|\n" +
                "      |  |   |   |   |  |\n" +
                "~~~~~~|~~|~~~|~~~|~~~|~~|~~~~~~",
                //6 airpurifier
                " _/*\\_    _/*\\_    _/*\\_    _/*\\_   \n" +
                "/     \\  /     \\  /     \\  /     \\  \n" +
                "|OXYGN|  |OXYGN|  |OXYGN|  |OXYGN|  \n" +
                "|     |  |     |  |     |  |     |  \n" +
                "|     |  |     |  |     |  |     |  \n" +
                "|     |  |     |  |     |  |     |  \n" +
                "|     |  |     |  |     |  |     |  \n" +
                "|     |  |     |  |     |  |     |  \n" +
                "\\_____/  \\_____/  \\_____/  \\_____/  ",
                //7 nuclear2
                "          ) ) )                     ) ) )\n" +
                "        ( ( (                      ( ( (\n" +
                "      ) ) )                       ) ) )\n" +
                "   (~~~~~~~~~)                 (~~~~~~~~~)\n" +
                "    |   2   |                   |   2   |\n" +
                "    |       |                   |       |\n" +
                "    |      _._                  |       _._\n" +
                "    |    /'   `\\                |     /'   `\\\n" +
                "    |   |   N   |               |    |   N   |\n" +
                "    |   |   |~~~~~~~~~~~~~~|    |    |    |~~~~~~~~~~~~~~|\n" +
                "  .'    |   ||~~~~~~~~|    |  .'     |    | |~~~~~~~~|   |\n" +
                "/'______|___||__###___|____|/'_______|____|_|__###___|___|",
                //8 nuclear3
                "          ) ) )                     ) ) )\n" +
                "        ( ( (                      ( ( (\n" +
                "      ) ) )                       ) ) )\n" +
                "   (~~~~~~~~~)                 (~~~~~~~~~)\n" +
                "    |   3   |                   |   3   |\n" +
                "    |       |                   |       |\n" +
                "    |      _._                  |       _._\n" +
                "    |    /'   `\\                |     /'   `\\\n" +
                "    |   |   N   |               |    |   N   |\n" +
                "    |   |   |~~~~~~~~~~~~~~|    |    |    |~~~~~~~~~~~~~~|\n" +
                "  .'    |   ||~~~~~~~~|    |  .'     |    | |~~~~~~~~|   |\n" +
                "/'______|___||__###___|____|/'_______|____|_|__###___|___|"};

        System.out.println("Save the Earth!\n" +
                "The goverment fucked up, did not pay attention to climate and failed.\n" +
                "Now it is your job to save the Earth by refreshing the air and making a stop to pollution.!\n" +
                "\n" +
                "Build Factories, Nuclear power plants, Forests and more to save the earth!\n" +
                "Your goal is to get pollution to 0!, Good luck!\n" +
                "\n");

        while (runGame)
        {

            turn = turn + 1;

            pollutionTurn =

            pollution = pollution + pollutionTurn + pollutionStandard;
            money = money + moneyTurn + moneyStandard;

            System.out.println("");


        }

    }
}