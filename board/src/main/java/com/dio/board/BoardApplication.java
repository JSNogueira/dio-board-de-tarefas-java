package com.dio.board;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dio.persistance.migration.MigrationStrategy;
import com.dio.ui.MainMenu;

import static com.dio.persistance.config.ConnectionConfig.getConnection;

import java.sql.SQLException;

@SpringBootApplication
public class BoardApplication {

	public static void main(String[] args) throws SQLException{

		 try(var connection = getConnection()){
			new MigrationStrategy(connection).executeMigration();
        }
        new MainMenu().execute();
	}

}
