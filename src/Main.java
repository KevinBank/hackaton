import java.util.Scanner;

public class Main {

    static Thread thread = new Thread();

    public static void main(String[] args) throws InterruptedException {
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
        int pollutionTurn;
        int pollutionStandard = 500;
        int money = 0;
        int moneyTurn;
        int moneyStandard = 250;
        int turn = 0;
        int buildings;

        boolean runGame = true;
        boolean select;

        String input;
        String[] command = {"build", "sleep", "info"};
        String[] building = {"farm", "forest", "windmills", "solarpanel", "factory", "oilrig", "airpurifier", "nuclear2", "nuclear3",};
        /*
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
                        */

        System.out.println("Save the Earth!\n" +
                "The goverment fucked up, did not pay attention to climate and failed.\n" +
                "Now it is your job to save the Earth by refreshing the air and making a stop to pollution.!\n" +
                "\n" +
                "Build Factories, Nuclear power plants, Forests and more to save the earth!\n" +
                "Your goal is to get pollution to 0!\n" +
                "If your pollution ever reaches 100000 you lose :(\n" +
                "\n");

        while (runGame) {

            turn = turn + 1;
            pollutionTurn = pollutionStandard + farm.pollution * farm.buildings + forest.pollution * forest.buildings + windmills.pollution * windmills.buildings + solarpanel.pollution * solarpanel.buildings + factory.pollution * factory.buildings + oilrig.pollution * oilrig.buildings + airpurifier.pollution * airpurifier.buildings + nuclear2.pollution * nuclear2.buildings + nuclear3.pollution * nuclear3.buildings;
            moneyTurn = moneyStandard + farm.production * farm.buildings + forest.production * forest.buildings + windmills.production * windmills.buildings + solarpanel.production * solarpanel.buildings + factory.production * factory.buildings + oilrig.production * oilrig.buildings + airpurifier.production * airpurifier.buildings + nuclear2.production * nuclear2.buildings + nuclear3.production * nuclear3.buildings;
            buildings = farm.buildings + forest.buildings + windmills.buildings + solarpanel.buildings + factory.buildings + oilrig.buildings + airpurifier.buildings + nuclear2.buildings + nuclear3.buildings;
            System.out.println(farm.production * farm.buildings);
            pollution = pollution + pollutionTurn;
            money = money + moneyTurn;

            System.out.println("Day " + turn + "\n" +
                    "\n" +
                    "Earths total pollution now is: " + pollution + "\n" +
                    "Difference: " + pollutionTurn + "\n" +
                    "\n" +
                    "Your total money: " + money + "\n" +
                    "You made " + moneyTurn + " yesterday\n" +
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
                    pollution + "/100000 Total pollution today\n" +
                    "\n" +
                    moneyTurn + " Money made today\n" +
                    money + " Total money today\n" +
                    "\n" +
                    buildings + " Building(s) built\n" +
                    "\n" +
                    "\n" +
                    "You can do the following commands:\n" +
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

            select = true;

            if (pollution > 100000)
            {
                System.out.println("You lost!");
                runGame = false;
                select = false;
            }

            while (select) {

                input = scan.nextLine();
                input = input.toLowerCase();

                if (input.equals(command[0])) {
                    System.out.println("What would you like to build?\n" +
                            "\n" +
                            "You have " + money + " money left\n" +
                            farm.cost + " Farm\n" +
                            forest.cost + " Forest\n" +
                            windmills.cost + " Windmills\n" +
                            solarpanel.cost + " Solarpanels\n" +
                            factory.cost + " Factory\n" +
                            oilrig.cost + " Oil rig\n" +
                            airpurifier.cost + " Air purifier\n" +
                            nuclear2.cost + " Nuclear power plant type 2\n" +
                            nuclear3.cost +  " Nuclear power plant type 3");

                    input = scan.nextLine();
                    input = input.toLowerCase();

                    if (input.equals(building[0])) {
                        if (money > farm.cost) {
                            farm.buildings = farm.buildings + 1;
                            money = money - farm.cost;
                            System.out.println("You bought 1 farm\n" +
                                    "You have " + farm.buildings + " farms now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + farm.cost + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(building[1])) {
                        if (money > forest.cost) {
                            forest.buildings = forest.buildings + 1;
                            money = money - forest.cost;
                            System.out.println("You bought 1 forest\n" +
                                    "You have " + forest.buildings + " forests now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + forest.cost + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(building[2])) {
                        if (money > windmills.cost) {
                            windmills.buildings = windmills.buildings + 1;
                            money = money - windmills.cost;
                            System.out.println("You bought 1 windmill\n" +
                                    "You have " + windmills.buildings + " windmills now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + windmills.cost + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(building[3])) {
                        if (money > solarpanel.cost) {
                            solarpanel.buildings = solarpanel.buildings + 1;
                            money = money - solarpanel.cost;
                            System.out.println("You bought 1 solarpanel\n" +
                                    "You have " + solarpanel.buildings + " solarpanels now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + solarpanel.cost + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(building[4])) {
                        if (money > factory.cost) {
                            factory.buildings = factory.buildings + 1;
                            money = money - factory.cost;
                            System.out.println("You bought 1 factory\n" +
                                    "You have " + factory.buildings + " factories now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + factory.cost + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(building[5])) {
                        if (money > oilrig.cost) {
                            oilrig.buildings = oilrig.buildings + 1;
                            money = money - oilrig.cost;
                            System.out.println("You bought 1 oilrig\n" +
                                    "You have " + oilrig.buildings + " oilrigs now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + oilrig.cost + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(building[6])) {
                        if (money > airpurifier.cost) {
                            airpurifier.buildings = airpurifier.buildings + 1;
                            money = money - airpurifier.cost;
                            System.out.println("You bought 1 airpurifier\n" +
                                    "You have " + airpurifier.buildings + " airpurifiers now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + airpurifier.cost + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(building[7])) {
                        if (money > nuclear2.cost) {
                            nuclear2.buildings = nuclear2.buildings + 1;
                            money = money - nuclear2.cost;
                            System.out.println("You bought 1 nuclear power plant type 2\n" +
                                    "You have " + nuclear2.buildings + " nuclear power plants type 2 now\n" +
                                    "\n" +
                                       "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + nuclear2.cost + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(building[8])) {
                        if (money > nuclear3.cost) {
                            nuclear3.buildings = nuclear3.buildings + 1;
                            money = money - nuclear3.cost;
                            System.out.println("You bought 1 nuclear power plant type 3\n" +
                                    "You have " + nuclear3.buildings + " nuclear power plants type 3 now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + nuclear3.cost + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    else
                    {
                        System.out.println("Please type any of the commands: Build, Sleep or Info");
                    }
                }
                if (input.equals(command[1])) {
                    System.out.println(".");
                    thread.sleep(1000);
                    System.out.println(".");
                    thread.sleep(1000);
                    System.out.println(".");
                    thread.sleep(1000);
                    select = false;
                }
                if (input.equals(command[2])) {
                    System.out.println("Farms:\n" +
                            farm.pollution + " Pollution\n" +
                            farm.production + " Money per day\n" +
                            "\n" +
                            "Forests:\n" +
                            forest.pollution + " Pollution\n" +
                            forest.production + " Money per day\n" +
                            "\n" +
                            "Windmills:\n" +
                            windmills.pollution + " Pollution\n" +
                            windmills.production + " Money per day\n" +
                            "\n" +
                            "Solarpanels:\n" +
                            solarpanel.pollution + " Pollution\n" +
                            solarpanel.production + " Money per day\n" +
                            "\n" +
                            "Factories\n" +
                            factory.pollution + " Pollution\n" +
                            factory.production + " Money per day\n" +
                            "\n" +
                            "Oil rigs:\n" +
                            oilrig.pollution + " Pollution\n" +
                            oilrig.production + " Money per day\n" +
                            "\n" +
                            "Airpurifiers:\n" +
                            airpurifier.pollution + " Pollution\n" +
                            airpurifier.production + " Money cost per day\n" +
                            "\n" +
                            "Nuclear power plant type 2\n" +
                            nuclear2.pollution + " Pollution\n" +
                            nuclear2.production + " Money per day\n" +
                            "\n" +
                            "Nuclear power plant type 3\n" +
                            nuclear3.pollution + " Pollution\n" +
                            nuclear3.production + " Money per day");

                }

            }

        }
    }
}