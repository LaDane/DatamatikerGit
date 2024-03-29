package web.commands;

import business.exceptions.UserException;
import business.persistence.Database;

import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class Command
{
    //Return a token string from the execute method to make a client side redirect,
    // instead of a server side (forward) redirect
    public final static String REDIRECT_INDICATOR = "#*redirect*#_###_";
    public final static String WAS_NOT_FOUND_COMMAND ="404_NOT_FOUND";

    private static HashMap<String, Command> commands;
    public static Database database;

    private static void initCommands(Database database)
    {
        commands = new HashMap<>();
        commands.put("index", new CommandUnprotectedPage("index"));
        commands.put("loginpage", new CommandUnprotectedPage("loginpage"));
        commands.put("logincommand", new LoginCommand(""));
        commands.put("logoutcommand", new LogoutCommand(""));
        commands.put("registerpage", new CommandUnprotectedPage("registerpage"));
        commands.put("registercommand", new RegisterCommand(""));
//        commands.put("customerpage", new CommandProtectedPage("customerpage", "customer"));
        commands.put("customerpage", new UserViewCommand("userpage", "customer"));
//        commands.put("employeepage", new CommandProtectedPage("employeepage", "employee"));
        commands.put("employeepage", new UserViewCommand("userpage", "employee"));

        commands.put("basket", new CommandUnprotectedPage("basket"));
        commands.put("basketRemoveCommand", new BasketRemoveCommand("basket"));
        commands.put("basketBuyCommand", new BasketBuyCommand("orderconfirmation", "customer"));
        commands.put("customerOrdersCommand", new CustomerOrdersCommand("customerorders", "customer"));
        commands.put("customerViewOrderCommand", new CustomerViewOrderCommand("customerorderspecific", "customer"));
        commands.put("employeeViewOrderCommand", new CustomerViewOrderCommand("customerorderspecific", "employee"));
        commands.put("employeeOrdersCommand", new EmployeeOrdersCommand("customerorders", "employee"));
        commands.put("usersCommand", new UsersCommand("users", "employee"));
        commands.put("userViewCommandEmployee", new UserViewCommand("userpage", "employee"));
        commands.put("userViewCommandCustomer", new UserViewCommand("userpage", "customer"));
        commands.put("userEditBalanceCommand", new UserEditBalanceCommand("userpage", "employee"));
        commands.put("orderRemoveCommand", new OrderRemoveCommand("customerorders", "employee"));
    }

    public static Command fromPath(
            HttpServletRequest request,
            Database db)
    {
        String action = request.getPathInfo().replaceAll("^/+", "");
        System.out.println("--> " + action);

        if (commands == null)
        {
            database = db;
            initCommands(database);
        }

        return commands.getOrDefault(action, new CommandUnknown());   // unknowncommand is default
    }

    public abstract String execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws UserException;

}
