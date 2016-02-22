package com.helpshift.mytask;

import com.helpshift.mytask.R;
import com.helpshift.mytask.database.MyDbHelper;
import com.helpshift.mytask.model.EmpDetails;

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
	private EditText edtName, edtSsn, edtDept;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;
//		create a database
		db = new MyDbHelper(context);

		btnAdd = (Button) findViewById(R.id.btn_add);

		edtName = (EditText) findViewById(R.id.edt_name);
		edtSsn = (EditText) findViewById(R.id.edt_ssn);
		edtDept = (EditText) findViewById(R.id.edt_dep);

		btnAdd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {

				String name = edtName.getText().toString();
				String ssn = edtSsn.getText().toString();
				String dept = edtDept.getText().toString();

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
						
						edtName.setText("");
						edtSsn.setText("");
						edtDept.setText("");
						edtSsn.setError(null);
						Toast.makeText(context, "Sucessfuly Inserted!!",
								Toast.LENGTH_SHORT).show();
					} else {
						edtSsn.setError("Check Employee ID");

					}

				} else {

					Toast.makeText(context, "Please Input Correct Data!!",
							Toast.LENGTH_SHORT).show();
				}

			}
		});

	}

}
