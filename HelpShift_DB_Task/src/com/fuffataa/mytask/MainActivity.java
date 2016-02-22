package com.fuffataa.mytask;

import com.fuffataa.mytask.database.MyDbHelper;
import com.fuffataa.mytask.model.EmpDetails;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	Context context;
	private Button btnAdd;
	private MyDbHelper db;
	private EditText edt_name, edt_ssn, edt_dept;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;
//		create a database
		db = new MyDbHelper(context);

		btnAdd = (Button) findViewById(R.id.btn_add);

		edt_name = (EditText) findViewById(R.id.edt_name);
		edt_ssn = (EditText) findViewById(R.id.edt_ssn);
		edt_dept = (EditText) findViewById(R.id.edt_dep);

		btnAdd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String name = edt_name.getText().toString();
				String ssn = edt_ssn.getText().toString();
				String dept = edt_dept.getText().toString();

//				check a normal validation
				
				if (name.length() != 0 && ssn.length() != 0
						&& dept.length() != 0) {

					EmpDetails details = new EmpDetails();
					details.setEmpName(name);
					details.setEmpSSN(ssn);
					details.setEmpDep(dept);
					
//					insert value into Db and pass the Model class reference
//					getter setter methods are used
					
					
					if (db.insertData(details)) {

//						clear the edit text boxes after inserting row
						
						edt_name.setText("");
						edt_ssn.setText("");
						edt_dept.setText("");
						edt_ssn.setError(null);
						Toast.makeText(context, "Sucessfuly Inserted!!",
								Toast.LENGTH_SHORT).show();
					} else {
						edt_ssn.setError("Check Employee ID");

					}

				} else {

					Toast.makeText(context, "Please Input Correct Data!!",
							Toast.LENGTH_SHORT).show();
				}

			}
		});

	}

}
