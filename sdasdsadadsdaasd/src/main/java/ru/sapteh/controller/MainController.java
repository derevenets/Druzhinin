package ru.sapteh.controller;

public class MainController {
    private ObservableList<User> userList = FXCollections.observableArrayList();

    @FXML
    private TableView<User> userTableView;

    @FXML
    private TableColumn<User, Integer> idColumn;

    @FXML
    private TableColumn<User, String> lastNameColumn;

    @FXML
    private TableColumn<User, String> firstNameColumn;


//    @FXML
//    private TableColumn<User, Date> regDateColumn;

    @FXML
    private TableColumn<User, Integer> countRoleColumn;
//
//    @FXML
//    private TableColumn<User, String> lastRegRoleColumn;

    @FXML
    public void initialize(){






        findByAllUserToDataBase();
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        firstNameColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getName()));
//        regDateColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue()
//                .getUserRoles().stream().findFirst().get().getRegistrationDate()));

        countRoleColumn.setCellValueFactory(p -> new SimpleObjectProperty<>(p.getValue().getSizeRole()));
//        lastRegRoleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));
//
        userTableView.setItems(userList);
    }


    private void findByAllUserToDataBase(){
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<User, Integer> userDaoImp = new UserDaoImp(factory);

        List<User> usersDataBase = userDaoImp.findByAll();

        userList.addAll(usersDataBase);

        factory.close();
    }
}
