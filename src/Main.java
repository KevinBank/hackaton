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
        int buildings;

        boolean runGame = true;
        boolean select = true;

        String input;
        String[] command = {"stop", "build", "sleep", "info"};
        String[] building = {"farm", "forest", "windmills", "solarpanel", "factory", "oilrig", "airpurifier", "nuclear2", "nuclear3",};
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
                "Your goal is to get pollution to 0!\n" +
                "If your pollution ever reaches 25000 you lose :(\n" +
                "\n");

        while (runGame)
        {

            turn = turn + 1;

            pollutionTurn = pollutionStandard + farm.totalPollution + forest.totalPollution + windmills.totalPollution + solarpanel.totalPollution + factory.totalPollution + oilrig.totalPollution + airpurifier.totalPollution + nuclear2.totalPollution + nuclear3.totalPollution;
            moneyTurn = moneyStandard + farm.totalProduction + forest.totalProduction + windmills.totalProduction + solarpanel.totalProduction + factory.totalProduction + oilrig.totalProduction + airpurifier.totalProduction + nuclear2.totalProduction + nuclear3.totalProduction;
            buildings = farm.buildings + forest.buildings + windmills.buildings + solarpanel.buildings + factory.buildings + oilrig.buildings + airpurifier.buildings + nuclear2.buildings + nuclear3.buildings;

            pollution = pollution + pollutionTurn;
            money = money + moneyTurn;

            System.out.println("Day " + turn + "\n" +
                    "\n" +
                    "Earths total pollution now is: " + pollution + "\n" +
                    "Difference: " + pollutionTurn + "\n" +
                    "\n" +
                    "Your total money: " + money + "\n" +
                    "You made " + money + " yesterday\n" +
                    "\n" +
                    "Building statistics:\n" +
                    "\n" +
                    "Farms:\n" +
                    farm.buildings + " Farms built\n" +
                    farm.totalPollution + " Pollution reduced by Farms\n" +
                    farm.totalProduction + " Total Farm production today\n" +
                    "\n" +
                    "Forests:\n" +
                    forest.buildings + " Forests built\n" +
                    forest.totalPollution + " Pollution reduced by Forests\n" +
                    forest.totalProduction + " Total Forest production today\n" +
                    "\n" +
                    "Windmills:\n" +
                    windmills.buildings + " Windmills built\n" +
                    windmills.totalPollution + " Pollution changed by Windmills\n" +
                    windmills.totalProduction + " Total Windmill production today\n" +
                    "\n" +
                    "Solarpanels:\n" +
                    solarpanel.buildings + " Solarpanels built\n" +
                    solarpanel.totalPollution + " Pollution changed by Solarpanels\n" +
                    solarpanel.totalProduction + " Total Solarpanel production today\n" +
                    "\n" +
                    "Factories:\n" +
                    factory.buildings + " Factories built\n" +
                    factory.totalPollution + " Pollution increased by Factories\n" +
                    factory.totalProduction + " Total Factory production today\n" +
                    "\n" +
                    "Oil rigs:\n" +
                    oilrig.buildings + " Oil rigs built\n" +
                    oilrig.totalPollution + " Pollution increased by Oil rigs\n" +
                    oilrig.totalProduction + " Total Oil rig production today\n" +
                    "\n" +
                    "Air purifiers:\n" +
                    airpurifier.buildings + " Air purifiers built\n" +
                    airpurifier.totalPollution + " Pollution reduced by Air purifiers\n" +
                    airpurifier.totalProduction + " Total Air purifier cost per day\n" +
                    "\n" +
                    "Nuclear power plant type 2:\n" +
                    nuclear2.buildings + " Nuclear power plants (type 2) built\n" +
                    nuclear2.totalPollution + " Pollution increased by Nuclear power plants (type 2)\n" +
                    nuclear2.totalProduction + " Total Nuclear power plant (Type 2) production today\n" +
                    "\n" +
                    "Nuclear power plant type 3:\n" +
                    nuclear3.buildings + " Nuclear power plants (type 3) built\n" +
                    nuclear3.totalPollution + " Pollution Increased by Nuclear power plants (type 3)\n" +
                    nuclear3.totalProduction + " Total Nuclear power plant (type 3) production today\n" +
                    "\n" +
                    "\n" +
                    "Totals:\n" +
                    pollutionTurn + " Pollution changed today\n" +
                    pollution + "/25000 Total pollution today\n" +
                    "\n" +
                    moneyTurn + " Money made today\n" +
                    money + " Total money today\n" +
                    "\n" +
                    buildings + " Buildings built\n" +
                    "\n" +
                    "\n" +
                    "You can do the following commands:\n" +
                    "\n" +
                    "Stop\n" +
                    "Stops any action and returns you to this menu\n" +
                    "\n" +
                    "Build\n" +
                    "Shows the build menu and allows you to build\n" +
                    "\n" +
                    "Sleep\n" +
                    "Ends your turn and a new day will begin!\n" +
                    "\n" +
                    "Info\n" +
                    "Shows you info about all buildings\n" +
                    "\n" +
                    "\n");

            while (select)
            {

                input = scan.nextLine();
                input = input.toLowerCase();

                if (input.equals(command[1]))
                {
                    System.out.println("What would you like to build?\n" +
                            "\n" +
                            "You have " + money + " money left\n" +
                            "100$    Farm\n" +
                            "500$    Forest\n" +
                            "500$    Windmills\n" +
                            "750$    Solarpanels\n" +
                            "2500$   Oil rig\n" +
                            "3250$   Air purifier\n" +
                            "5000$   Nuclear power plant type 2\n" +
                            "25000$  Nuclear power plant type 3");

                    input = scan.nextLine();
                    input = input.toLowerCase();

                    if (input.equals(building[0]))
                    {
                        farm.buildings = farm.buildings + 1;
                        System.out.println("You bought 1 farm\n" +
                                "You have " + farm.buildings + " farms now\n" +
                                "\n" +
                                "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                    }
                    if (input.equals(building[1]))
                    {
                        farm.buildings = farm.buildings + 1;
                        System.out.println("You bought 1 farm\n" +
                                "You have " + farm.buildings + " farms now\n" +
                                "\n" +
                                "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                    }
                    if (input.equals(building[2]))
                    {
                        farm.buildings = farm.buildings + 1;
                        System.out.println("You bought 1 farm\n" +
                                "You have " + farm.buildings + " farms now\n" +
                                "\n" +
                                "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                    }
                    if (input.equals(building[3]))
                    {
                        farm.buildings = farm.buildings + 1;
                        System.out.println("You bought 1 farm\n" +
                                "You have " + farm.buildings + " farms now\n" +
                                "\n" +
                                "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                    }
                    if (input.equals(building[4]))
                    {
                        farm.buildings = farm.buildings + 1;
                        System.out.println("You bought 1 farm\n" +
                                "You have " + farm.buildings + " farms now\n" +
                                "\n" +
                                "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                    }
                    if (input.equals(building[5]))
                    {
                        farm.buildings = farm.buildings + 1;
                        System.out.println("You bought 1 farm\n" +
                                "You have " + farm.buildings + " farms now\n" +
                                "\n" +
                                "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                    }
                    if (input.equals(building[6]))
                    {
                        farm.buildings = farm.buildings + 1;
                        System.out.println("You bought 1 farm\n" +
                                "You have " + farm.buildings + " farms now\n" +
                                "\n" +
                                "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                    }
                    if (input.equals(building[7]))
                    {
                        farm.buildings = farm.buildings + 1;
                        System.out.println("You bought 1 farm\n" +
                                "You have " + farm.buildings + " farms now\n" +
                                "\n" +
                                "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                    }
                }
                if (input.equals(command[2]))
                {
                    System.out.println("sleep");
                }
                if (input.equals(command[3]))
                {
                    System.out.println("info");
                }

            }

        }

    }
}