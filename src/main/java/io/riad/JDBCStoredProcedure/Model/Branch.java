package io.riad.JDBCStoredProcedure.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class Branch {

	String branchName;
	String branchCity;
	int assets;
	
	
	
}
