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
        int pollutionStandard = 0;
        int money = 0;
        int moneyTurn;
        int moneyStandard = 0;
        int turn = 0;
        int buildings;

        boolean runGame = true;
        boolean select;

        String input;
        String[] command = {"build", "sleep", "info"};
        String[] building = {"farm", "forest", "windmills", "solarpanels", "factory", "oilrig", "airpurifier", "nuclear2", "nuclear3"};
        String[] buildingFive = {"5farm", "5forest", "5windmills", "5solarpanels", "5factory", "5oilrig", "5airpurifier", "5nuclear2", "5nuclear3"};
        String[] buildingTen = {"10farm", "10forest", "10windmills", "10solarpanels", "10factory", "10oilrig", "10airpurifier", "10nuclear2", "10nuclear3"};
        String[] difficulty = {"easy", "normal", "medium", "hard", "insane", "dev"};
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
                "\n" +
                "\n" +
                "\n" +
                "Chose your difficulty!\n" +
                "\n" +
                "Easy\n" +
                "Normal\n" +
                "Medium\n" +
                "Hard\n" +
                "Insane\n" +
                "\n" +
                "Reccomended: Hard or medium");

        input = scan.nextLine();
        input = input.toLowerCase();

        if (input.equals(difficulty[0])) //easy
        {
            pollutionStandard = 2500;
            moneyStandard = 250;
        }
        if (input.equals(difficulty[1])) //normal
        {
            pollutionStandard = 3000;
            moneyStandard = 200;
        }
        if (input.equals(difficulty[2])) //medium
        {
            pollutionStandard = 4000;
            moneyStandard = 175;
        }
        if (input.equals(difficulty[3])) //hard
        {
            pollutionStandard = 5000;
            moneyStandard = 125;
        }
        if (input.equals(difficulty[4])) //insane
        {
            pollutionStandard = 6000;
            moneyStandard = 100;
        }
        if (input.equals(difficulty[5])) //developer
        {
            pollutionStandard = 5000;
            moneyStandard = 9999999;
        }


        while (runGame) {

            turn = turn + 1;

            pollutionTurn = pollutionStandard + farm.pollution * farm.buildings + forest.pollution * forest.buildings + windmills.pollution * windmills.buildings + solarpanel.pollution * solarpanel.buildings + factory.pollution * factory.buildings + oilrig.pollution * oilrig.buildings + airpurifier.pollution * airpurifier.buildings + nuclear2.pollution * nuclear2.buildings + nuclear3.pollution * nuclear3.buildings;
            moneyTurn = moneyStandard + farm.production * farm.buildings + forest.production * forest.buildings + windmills.production * windmills.buildings + solarpanel.production * solarpanel.buildings + factory.production * factory.buildings + oilrig.production * oilrig.buildings + airpurifier.production * airpurifier.buildings + nuclear2.production * nuclear2.buildings + nuclear3.production * nuclear3.buildings;

            buildings = farm.buildings + forest.buildings + windmills.buildings + solarpanel.buildings + factory.buildings + oilrig.buildings + airpurifier.buildings + nuclear2.buildings + nuclear3.buildings;
            pollution = pollution + pollutionTurn;
            money = money + moneyTurn;

            farm.totalPollution = farm.pollution * farm.buildings;
            farm.totalProduction = farm.production * farm.buildings;
            forest.totalPollution = forest.pollution * forest.buildings;
            forest.totalProduction = forest.production * forest.buildings;
            windmills.totalPollution = windmills.pollution * windmills.buildings;
            windmills.totalProduction = windmills.production * windmills.buildings;
            solarpanel.totalPollution = solarpanel.pollution * solarpanel.buildings;
            solarpanel.totalProduction = solarpanel.production * solarpanel.buildings;
            factory.totalPollution = factory.pollution * factory.buildings;
            factory.totalProduction = factory.production * factory.buildings;
            oilrig.totalPollution = oilrig.pollution * oilrig.buildings;
            oilrig.totalProduction = oilrig.production * oilrig.buildings;
            airpurifier.totalPollution = airpurifier.pollution * airpurifier.buildings;
            airpurifier.totalProduction = airpurifier.production * airpurifier.buildings;
            nuclear2.totalPollution = nuclear2.pollution * nuclear2.buildings;
            nuclear2.totalProduction = nuclear2.production * nuclear2.buildings;
            nuclear3.totalPollution = nuclear3.pollution * nuclear3.buildings;
            nuclear3.totalProduction = nuclear3.production * nuclear3.buildings;


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
                    windmills.totalPollution + " Pollution reduced by Windmills\n" +
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

            if (pollution >= 100000) {
                System.out.println("You lost!\n" +
                        "You were on day: " + turn);
                runGame = false;
                select = false;
            }
            if (pollution <= 0)
                System.out.println("You won\n" +
                        "You did it in " + turn + "days!");

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
                            oilrig.cost + " Oilrig\n" +
                            airpurifier.cost + " Airpurifier\n" +
                            nuclear2.cost + " (Nuclear2) Nuclear power plant type 2\n" +
                            nuclear3.cost + " (Nuclear3) Nuclear power plant type 3\n" +
                            "\n" +
                            "If you would like to build more of the same building in one go,\n" +
                            "Simply put a '5' or a '10' before you enter the type of building\n" +
                            "For instance: 5 Farm or 10 Factory");

                    input = scan.nextLine();
                    input = input.toLowerCase();

                    if (input.equals(building[0])) {
                        if (money >= farm.cost) {
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
                        if (money >= forest.cost) {
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
                        if (money >= windmills.cost) {
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
                        if (money >= solarpanel.cost) {
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
                        if (money >= factory.cost) {
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
                        if (money >= oilrig.cost) {
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
                        if (money >= airpurifier.cost) {
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
                        if (money >= nuclear2.cost) {
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
                        if (money >= nuclear3.cost) {
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


                    if (input.equals(buildingFive[0])) {
                        if (money >= farm.cost * 5) {
                            farm.buildings = farm.buildings + 5;
                            money = money - farm.cost;
                            System.out.println("You bought 1 farm\n" +
                                    "You have " + farm.buildings + " farms now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + farm.cost * 5 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingFive[1])) {
                        if (money >= forest.cost * 5) {
                            forest.buildings = forest.buildings + 5;
                            money = money - forest.cost * 5;
                            System.out.println("You bought 1 forest\n" +
                                    "You have " + forest.buildings + " forests now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + forest.cost * 5 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingFive[2])) {
                        if (money >= windmills.cost * 5) {
                            windmills.buildings = windmills.buildings + 5;
                            money = money - windmills.cost * 5;
                            System.out.println("You bought 1 windmill\n" +
                                    "You have " + windmills.buildings + " windmills now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + windmills.cost * 5 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingFive[3])) {
                        if (money >= solarpanel.cost * 5) {
                            solarpanel.buildings = solarpanel.buildings + 5;
                            money = money - solarpanel.cost * 5;
                            System.out.println("You bought 1 solarpanel\n" +
                                    "You have " + solarpanel.buildings + " solarpanels now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + solarpanel.cost * 5 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingFive[4])) {
                        if (money >= factory.cost * 5) {
                            factory.buildings = factory.buildings + 5;
                            money = money - factory.cost * 5;
                            System.out.println("You bought 1 factory\n" +
                                    "You have " + factory.buildings + " factories now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + factory.cost * 5 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingFive[5])) {
                        if (money >= oilrig.cost * 5) {
                            oilrig.buildings = oilrig.buildings + 5;
                            money = money - oilrig.cost * 5;
                            System.out.println("You bought 1 oilrig\n" +
                                    "You have " + oilrig.buildings + " oilrigs now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + oilrig.cost * 5 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingFive[6])) {
                        if (money >= airpurifier.cost * 5) {
                            airpurifier.buildings = airpurifier.buildings + 5;
                            money = money - airpurifier.cost * 5;
                            System.out.println("You bought 1 airpurifier\n" +
                                    "You have " + airpurifier.buildings + " airpurifiers now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + airpurifier.cost * 5 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingFive[7])) {
                        if (money >= nuclear2.cost * 5) {
                            nuclear2.buildings = nuclear2.buildings + 5;
                            money = money - nuclear2.cost * 5;
                            System.out.println("You bought 1 nuclear power plant type 2\n" +
                                    "You have " + nuclear2.buildings + " nuclear power plants type 2 now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + nuclear2.cost * 5 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingFive[8])) {
                        if (money >= nuclear3.cost * 5) {
                            nuclear3.buildings = nuclear3.buildings + 5;
                            money = money - nuclear3.cost * 5;
                            System.out.println("You bought 1 nuclear power plant type 3\n" +
                                    "You have " + nuclear3.buildings + " nuclear power plants type 3 now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + nuclear3.cost * 5 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }


                    if (input.equals(buildingTen[0])) {
                        if (money >= farm.cost * 10) {
                            farm.buildings = farm.buildings + 10;
                            money = money - farm.cost;
                            System.out.println("You bought 1 farm\n" +
                                    "You have " + farm.buildings + " farms now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + farm.cost * 10 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingTen[1])) {
                        if (money >= forest.cost * 10) {
                            forest.buildings = forest.buildings + 10;
                            money = money - forest.cost * 10;
                            System.out.println("You bought 1 forest\n" +
                                    "You have " + forest.buildings + " forests now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + forest.cost * 10 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingTen[2])) {
                        if (money >= windmills.cost * 10) {
                            windmills.buildings = windmills.buildings + 10;
                            money = money - windmills.cost * 10;
                            System.out.println("You bought 1 windmill\n" +
                                    "You have " + windmills.buildings + " windmills now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + windmills.cost * 10 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingTen[3])) {
                        if (money >= solarpanel.cost * 10) {
                            solarpanel.buildings = solarpanel.buildings + 10;
                            money = money - solarpanel.cost * 10;
                            System.out.println("You bought 1 solarpanel\n" +
                                    "You have " + solarpanel.buildings + " solarpanels now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + solarpanel.cost * 10 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingTen[4])) {
                        if (money >= factory.cost * 10) {
                            factory.buildings = factory.buildings + 10;
                            money = money - factory.cost * 10;
                            System.out.println("You bought 1 factory\n" +
                                    "You have " + factory.buildings + " factories now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + factory.cost * 10 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingTen[5])) {
                        if (money >= oilrig.cost * 10) {
                            oilrig.buildings = oilrig.buildings + 10;
                            money = money - oilrig.cost * 10;
                            System.out.println("You bought 1 oilrig\n" +
                                    "You have " + oilrig.buildings + " oilrigs now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + oilrig.cost * 10 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingTen[6])) {
                        if (money >= airpurifier.cost * 10) {
                            airpurifier.buildings = airpurifier.buildings + 10;
                            money = money - airpurifier.cost * 10;
                            System.out.println("You bought 1 airpurifier\n" +
                                    "You have " + airpurifier.buildings + " airpurifiers now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + airpurifier.cost * 10 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingTen[7])) {
                        if (money >= nuclear2.cost * 10) {
                            nuclear2.buildings = nuclear2.buildings + 10;
                            money = money - nuclear2.cost * 10;
                            System.out.println("You bought 1 nuclear power plant type 2\n" +
                                    "You have " + nuclear2.buildings + " nuclear power plants type 2 now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + nuclear2.cost * 10 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    }
                    if (input.equals(buildingTen[8])) {
                        if (money >= nuclear3.cost * 10) {
                            nuclear3.buildings = nuclear3.buildings + 10;
                            money = money - nuclear3.cost * 10;
                            System.out.println("You bought 1 nuclear power plant type 3\n" +
                                    "You have " + nuclear3.buildings + " nuclear power plants type 3 now\n" +
                                    "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        } else {
                            System.out.println("Not enough money!\n" +
                                    "It costs " + nuclear3.cost * 10 + " but you have " + money + "\n" +
                                    "Would you like to do anything else? Type one of the commands or 'Sleep' to go to the next day");
                        }
                    } else  {
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
                            farm.cost + "$" +
                            "\n" +
                            "Forests:\n" +
                            forest.pollution + " Pollution\n" +
                            forest.production + " Money per day\n" +
                            forest.cost + "$" +
                            "\n" +
                            "Windmills:\n" +
                            windmills.pollution + " Pollution\n" +
                            windmills.production + " Money per day\n" +
                            windmills.cost + "$" +
                            "\n" +
                            "Solarpanels:\n" +
                            solarpanel.pollution + " Pollution\n" +
                            solarpanel.production + " Money per day\n" +
                            solarpanel.cost + "$" +
                            "\n" +
                            "Factories\n" +
                            factory.pollution + " Pollution\n" +
                            factory.production + " Money per day\n" +
                            factory.cost + "$" +
                            "\n" +
                            "Oil rigs:\n" +
                            oilrig.pollution + " Pollution\n" +
                            oilrig.production + " Money per day\n" +
                            oilrig.cost + "$" +
                            "\n" +
                            "Airpurifiers:\n" +
                            airpurifier.pollution + " Pollution\n" +
                            airpurifier.production + " Money cost per day\n" +
                            airpurifier.cost + "$" +
                            "\n" +
                            "Nuclear power plant type 2\n" +
                            nuclear2.pollution + " Pollution\n" +
                            nuclear2.production + " Money per day\n" +
                            nuclear2.cost + "$" +
                            "\n" +
                            "Nuclear power plant type 3\n" +
                            nuclear3.pollution + " Pollution\n" +
                            nuclear3.production + " Money per day\n" +
                            nuclear3.cost + "$");
                }

            }

        }
    }
}
// Still need to add: x 5 and x 10 buildings.