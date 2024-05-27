package com.example.railwaytimeprediction.platformsPackage;
import static com.example.railwaytimeprediction.platformsPackage.MainActivity.string;
import static com.example.railwaytimeprediction.platformsPackage.FragmentHome.queryHistoryDatabase;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.example.railwaytimeprediction.R;
import com.example.railwaytimeprediction.allDatabasePackage.variablesPackage.VariablesDatabase;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class FragmentAllPlatforms extends Fragment {
    private VariablesDatabase variablesDatabase;
    private Button escapeButton, startButton, departureButton, arrivalButton, showStationList, dialogEscapeButton;
    public static Boolean departureConfirm = false, arrivalConfirm = false;
    private ListView listView, showListView;
    private EditText editText;
    private ArrayList<String> stationNames, showStationNames;
    private ArrayList<Integer> stationRanges;
    private ArrayAdapter<String> arrayAdapter;
    private TextView titleTextView, departureStation, arrivalStation, timeInfo, howMuchTime,howManyPlatform;
    private ConstraintLayout constraintLayout;
    private LinearLayout linearLayout;
    private int departureStationIndex, arrivalStationIndex, Hour, Min;
    public static String departureStationName, arrivalStationName;
    private String stringHour, stringMin;
    private Dialog dialog, stationListDialog;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch aSwitch;
    private SimpleDateFormat currentDateAndTime;
    private String depTime;
    private String arrTime;
    private int StationCounter;
    private int totalMin;
    private String currentPlatform;
    public static String currentMail;
    public static Integer currentID;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_all_platforms, container, false);

        ImageView imageView = (ImageView) v.findViewById(R.id.image);
        departureButton = (Button) v.findViewById(R.id.departure_button);
        arrivalButton = (Button) v.findViewById(R.id.arrival_button);
        startButton = (Button) v.findViewById(R.id.start_button);
        escapeButton = (Button) v.findViewById(R.id.escape_button);
        aSwitch = (Switch) v.findViewById(R.id.switch_button);

        currentPlatform = getPlatform(imageView);
        variablesDatabase = new VariablesDatabase(getActivity());

        departureStation= (TextView) v.findViewById(R.id.departure_station);
        arrivalStation = (TextView) v.findViewById(R.id.arrival_station);
        timeInfo = (TextView) v.findViewById(R.id.time_info);
        howMuchTime = (TextView) v.findViewById(R.id.how_much_time);
        howManyPlatform = (TextView) v.findViewById(R.id.how_many_platform);
        constraintLayout = (ConstraintLayout) v.findViewById(R.id.output);
        showStationList = (Button) v.findViewById(R.id.show_station_list);

        ArrayListImport(currentPlatform);

        dialog = new Dialog(requireActivity());
        dialog.setContentView(R.layout.dialog_searchable_spinner);
        Objects.requireNonNull(dialog.getWindow()).setLayout(800, 1200);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        editText = (EditText) dialog.findViewById(R.id.edit_text);
        titleTextView = (TextView) dialog.findViewById(R.id.select_station_title);
        linearLayout = (LinearLayout) dialog.findViewById(R.id.searchable_spinner_layout);

        listView = dialog.findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter<String>(requireActivity(), R.layout.list_item, R.id.text_view, stationNames);
        listView.setAdapter(arrayAdapter);

        departureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleTextView.setText(R.string.kalkis);

                if(aSwitch.isChecked())
                    linearLayout.setBackgroundResource(R.drawable.switch_on_output_background_tiny_line);
                else
                    linearLayout.setBackgroundResource(R.drawable.switch_off_output_background_tiny_line);

                dialog.show();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        departureStationName = (String) ((ListView) parent).getAdapter().getItem(position);

                        for(int i = 0; i < stationNames.size(); i++)
                            if(stationNames.get(i).equals(departureStationName))
                                departureStationIndex = i;


                        departureButton.setText(departureStationName);
                        departureButton.setTextSize(25);
                        departureButton.setTypeface(null, Typeface.BOLD);

                        editText.setText("");
                        editText.clearFocus();

                        departureConfirm = true;

                        dialog.dismiss();

                        if(aSwitch.isChecked())
                            departureButton.setBackgroundResource(R.drawable.switch_on_without_icon_button);
                        else
                            departureButton.setBackgroundResource(R.drawable.switch_off_without_icon_button);

                        constraintLayout.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        arrivalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleTextView.setText(R.string.varis);

                if(aSwitch.isChecked())
                    linearLayout.setBackgroundResource(R.drawable.switch_on_output_background_tiny_line);
                else
                    linearLayout.setBackgroundResource(R.drawable.switch_off_output_background_tiny_line);

                dialog.show();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        arrivalStationName = (String) ((ListView) parent).getAdapter().getItem(position);

                        for(int i = 0; i < stationNames.size(); i++)
                            if(stationNames.get(i).equals(arrivalStationName))
                                arrivalStationIndex = i;

                        arrivalButton.setText(arrivalStationName);
                        arrivalButton.setTextSize(25);
                        arrivalButton.setTypeface(null, Typeface.BOLD);

                        editText.setText("");
                        editText.clearFocus();

                        arrivalConfirm = true;

                        dialog.dismiss();

                        if(aSwitch.isChecked())
                            arrivalButton.setBackgroundResource(R.drawable.switch_on_without_icon_button);
                        else
                            arrivalButton.setBackgroundResource(R.drawable.switch_off_without_icon_button);

                        constraintLayout.setVisibility(View.INVISIBLE);
                    }
                });
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                constraintLayout.setVisibility(View.INVISIBLE);

                if (isChecked) {
                    constraintLayout.setBackground(ContextCompat.getDrawable(requireActivity(), R.drawable.switch_on_output_background));

                    if(departureConfirm)
                        departureButton.setBackgroundResource(R.drawable.switch_on_without_icon_button);
                    else
                        departureButton.setBackgroundResource(R.drawable.switch_on_with_icon_button);

                    if(arrivalConfirm)
                        arrivalButton.setBackgroundResource(R.drawable.switch_on_without_icon_button);
                    else
                        arrivalButton.setBackgroundResource(R.drawable.switch_on_with_icon_button);

                    escapeButton.setBackgroundResource(R.drawable.switch_on_escape_button);
                    startButton.setBackgroundResource(R.drawable.switch_on_without_icon_button);
                    showStationList.setBackgroundResource(R.drawable.switch_on_without_icon_button);

                    TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker timePicker, int hour, int min) {
                            Hour = hour;
                            Min = min;
                        }
                    };

                    TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), onTimeSetListener, Hour, Min, true);

                    timePickerDialog.setButton(DialogInterface.BUTTON_POSITIVE, "ONAYLA", timePickerDialog);
                    timePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "İPTAL ET", timePickerDialog);
                    timePickerDialog.show();

                    timePickerDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which)
                        {
                            if (which == DialogInterface.BUTTON_NEGATIVE)
                            {
                                aSwitch.setChecked(false);

                                if(departureConfirm)
                                    departureButton.setBackgroundResource(R.drawable.switch_off_without_icon_button);
                                else
                                    departureButton.setBackgroundResource(R.drawable.switch_off_with_icon_button);

                                if(arrivalConfirm)
                                    arrivalButton.setBackgroundResource(R.drawable.switch_off_without_icon_button);
                                else
                                    arrivalButton.setBackgroundResource(R.drawable.switch_off_with_icon_button);

                                escapeButton.setBackgroundResource(R.drawable.switch_off_escape_button);
                                startButton.setBackgroundResource(R.drawable.switch_off_without_icon_button);
                            }
                        }
                    });
                }
                else {
                    constraintLayout.setBackground(ContextCompat.getDrawable(requireActivity(), R.drawable.switch_off_output_background));

                    if(departureConfirm)
                        departureButton.setBackgroundResource(R.drawable.switch_off_without_icon_button);
                    else
                        departureButton.setBackgroundResource(R.drawable.switch_off_with_icon_button);

                    if(arrivalConfirm)
                        arrivalButton.setBackgroundResource(R.drawable.switch_off_without_icon_button);
                    else
                        arrivalButton.setBackgroundResource(R.drawable.switch_off_with_icon_button);

                    escapeButton.setBackgroundResource(R.drawable.switch_off_escape_button);
                    startButton.setBackgroundResource(R.drawable.switch_off_without_icon_button);
                    showStationList.setBackgroundResource(R.drawable.switch_off_without_icon_button);
                }
            }
        });

        startButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {

                if (departureStationName.equals("") || arrivalStationName.equals("")){
                    Toast.makeText(getActivity(), "Boş Bırakılan Alanlar Var", Toast.LENGTH_LONG).show();
                }
                else if (departureStationName.equals(arrivalStationName)) {
                    Toast.makeText(getActivity(), "Kalkış ve Varış Durakları Aynı Olamaz", Toast.LENGTH_LONG).show();
                }
                else {
                    setHourMinVariables();
                    showStationListImport(departureStationIndex, arrivalStationIndex, currentPlatform);

                    totalMin = countMin();
                    depTime = getDepTime(stringHour, stringMin);
                    arrTime = getArrivalTime(totalMin);
                    StationCounter = (Math.abs(departureStationIndex - arrivalStationIndex));

                    departureStation.setText(departureStationName);
                    arrivalStation.setText(arrivalStationName);
                    timeInfo.setText(depTime + "->" + arrTime);
                    howMuchTime.setText(totalMin + " Dakika");
                    howManyPlatform.setText(StationCounter + " Durak");

                    constraintLayout.setVisibility(View.VISIBLE);

                    currentDateAndTime = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
                    String dateAndTime = currentDateAndTime.format(new Date());

                    queryHistoryDatabase.insertData(currentPlatform, dateAndTime, departureStationName, arrivalStationName, depTime, arrTime, StationCounter, totalMin, currentID);

                    showStationList.setOnClickListener(new View.OnClickListener() {
                        @SuppressLint("ResourceAsColor")
                        @Override
                        public void onClick(View view) {
                            stationListDialog = new Dialog(requireActivity());

                            if (aSwitch.isChecked())
                                stationListDialog.setContentView(R.layout.switch_on_dialog_show_station_list);
                            else
                                stationListDialog.setContentView(R.layout.switch_off_dialog_show_station_list);

                            Objects.requireNonNull(stationListDialog.getWindow()).setLayout(800, 1200);
                            stationListDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                            dialogEscapeButton = (Button) stationListDialog.findViewById(R.id.escape_button);
                            showListView = stationListDialog.findViewById(R.id.list_view);

                            arrayAdapter = new ArrayAdapter<String>(requireActivity(), R.layout.list_item, R.id.text_view, showStationNames);
                            showListView.setAdapter(arrayAdapter);

                            stationListDialog.show();

                            dialogEscapeButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    stationListDialog.dismiss();
                                }
                            });
                        }
                    });
                }
            }
        });

        escapeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new FragmentHome()).commit();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        return v;
    }

    public String getPlatform(ImageView imageView) {
        switch (string) {
            case "Metro - 1A":
                imageView.setImageResource(R.drawable.m1a);
                return "m1a";
            case "Metro - 1B":
                imageView.setImageResource(R.drawable.m1b);
                return "m1b";
            case "Metro - 2":
                imageView.setImageResource(R.drawable.m2);
                return "m2";
            case "Metro - 3":
                imageView.setImageResource(R.drawable.m3);
                return "m3";
            case "Metro - 4":
                imageView.setImageResource(R.drawable.m4);
                return "m4";
            case "Metro - 5":
                imageView.setImageResource(R.drawable.m5);
                return "m5";
            case "Metro - 6":
                imageView.setImageResource(R.drawable.m6);
                return "m6";
            case "Metro - 7":
                imageView.setImageResource(R.drawable.m7);
                return "m7";
            case "Metro - 8":
                imageView.setImageResource(R.drawable.m8);
                return "m8";
            case "Metro - 9":
                imageView.setImageResource(R.drawable.m9);
                return "m9";
            case "Metro - 10":
                imageView.setImageResource(R.drawable.m10);
                return "m10";
            case "Metro - 11":
                imageView.setImageResource(R.drawable.m11);
                return "m11";
            case "Metro - 12":
                imageView.setImageResource(R.drawable.m12);
                return "m12";
            case "Metro - 13":
                imageView.setImageResource(R.drawable.m13);
                return "m13";
            case "Metro - 14":
                imageView.setImageResource(R.drawable.m14);
                return "m14";
            case "Füniküler - 1":
                imageView.setImageResource(R.drawable.f1);
                return "f1";
            case "Füniküler - 2":
                imageView.setImageResource(R.drawable.f2);
                return "f2";
            case "Füniküler - 3":
                imageView.setImageResource(R.drawable.f3);
                return "f3";
            case "Füniküler - 4":
                imageView.setImageResource(R.drawable.f4);
                return "f4";
            case "Füniküler - 5":
                imageView.setImageResource(R.drawable.f5);
                return "f5";
            case "Tramvay - 1":
                imageView.setImageResource(R.drawable.t1);
                return "t1";
            case "Tramvay - 2":
                imageView.setImageResource(R.drawable.t2);
                return "t2";
            case "Tramvay - 3":
                imageView.setImageResource(R.drawable.t3);
                return "t3";
            case "Tramvay - 4":
                imageView.setImageResource(R.drawable.t4);
                return "t4";
            case "Tramvay - 5":
                imageView.setImageResource(R.drawable.t5);
                return "t5";
            case "Tramvay - 6":
                imageView.setImageResource(R.drawable.t6);
                return "t6";
            case "Teleferik - 1":
                imageView.setImageResource(R.drawable.tf1);
                return "tf1";
            case "Teleferik - 2":
                imageView.setImageResource(R.drawable.tf2);
                return "tf2";
            default:
                imageView.setImageResource(R.drawable.marmaray);
                return "marmaray";
        }
    }

    public int countMin() {
        int sum = 0;

        for(int i = Math.min(departureStationIndex, arrivalStationIndex); i < Math.max(departureStationIndex, arrivalStationIndex); i++)
            sum += stationRanges.get(i);

        if((sum % 60) >= 30) {
            sum = sum / 60;
            sum = sum + 1;
        }
        else {
            sum = sum / 60;
        }

        return sum;
    }

    public void setHourMinVariables() {
        if(!aSwitch.isChecked()) {
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdfH = new SimpleDateFormat("HH");
            @SuppressLint("SimpleDateFormat") SimpleDateFormat sdfM = new SimpleDateFormat("mm");

            Hour = Integer.parseInt(sdfH.format(new Date()));
            Min = Integer.parseInt(sdfM.format(new Date()));

            if(Hour < 9) {
                stringHour = "0" + Hour;
            }
            else {
                stringHour = Integer.toString(Hour);
            }

            if(Min < 9) {
                stringMin = "0" + Min;
            }
            else {
                stringMin = Integer.toString(Min);
            }
        }
        else {
            if(Hour < 9) {
                stringHour = "0" + Hour;
            }
            else {
                stringHour = Integer.toString(Hour);
            }

            if(Min < 9) {
                stringMin = "0" + Min;
            }
            else {
                stringMin = Integer.toString(Min);
            }
        }
    }

    public String getDepTime(String stringHour, String stringMin) {
        String currentDateAndTime;
        int H = Integer.parseInt(stringHour);
        int M = Integer.parseInt(stringMin);

        if (H <= 9)
            currentDateAndTime = "0" + H + ".";
        else
            currentDateAndTime = H + ".";

        if (M <= 9)
            currentDateAndTime = currentDateAndTime + "0" + M;
        else
            currentDateAndTime = currentDateAndTime + M;

        return currentDateAndTime;
    }

    public String getArrivalTime(int totalMin) {
        String currentDateAndTime;

        if ((Hour + ((Min + totalMin) / 60)) >= 24)
            if(((Hour + ((Min + totalMin) / 60)) - 24) <= 9)
                if (((Min + totalMin) % 60) <= 9)
                    currentDateAndTime = "0" + ((Hour + ((Min + totalMin) / 60)) - 24) + ".0" + ((Min + totalMin) % 60);
                else
                    currentDateAndTime = "0" + ((Hour + ((Min + totalMin) / 60)) - 24) + "." + ((Min + totalMin) % 60);
            else
                if (((Min + totalMin) % 60) <= 9)
                    currentDateAndTime = ((Hour + ((Min + totalMin) / 60)) - 24) + ".0" + ((Min + totalMin) % 60);
                else
                    currentDateAndTime = ((Hour + ((Min + totalMin) / 60)) - 24) + "." + ((Min + totalMin) % 60);
        else if((Hour + ((Min + totalMin) / 60)) <= 9)
            if (((Min + totalMin) % 60) <= 9)
                currentDateAndTime = "0" + (Hour + ((Min + totalMin) / 60)) + ".0" + ((Min + totalMin) % 60);
            else
                currentDateAndTime = "0" + (Hour + ((Min + totalMin) / 60)) + "." + ((Min + totalMin) % 60);
        else
            if (((Min + totalMin) % 60) <= 9)
                currentDateAndTime = (Hour + ((Min + totalMin) / 60)) + ".0" + ((Min + totalMin) % 60);
            else
                currentDateAndTime = (Hour + ((Min + totalMin) / 60)) + "." + ((Min + totalMin) % 60);

        return currentDateAndTime;
    }

    public void ArrayListImport(String platform) {
        stationNames = new ArrayList<>();
        stationRanges = new ArrayList<>();

        Cursor cursor = variablesDatabase.getAllData(platform);

        if(cursor.getCount() != 0) {
            while(cursor.moveToNext()) {
                stationNames.add(cursor.getString(1));

                if(cursor.getString(2).equals(""))
                    break;

                stationRanges.add(Integer.valueOf(cursor.getString(2)));
            }
        }
    }

    public void showStationListImport(Integer departureStationIndex, Integer arrivalStationIndex, String platform) {
        ArrayList<String> tempList = new ArrayList<>();
        Cursor cursor = variablesDatabase.getAllData(platform);
        if(cursor.getCount() != 0)
            while(cursor.moveToNext())
                tempList.add(cursor.getString(1));

        showStationNames = new ArrayList<>();
        if(arrivalStationIndex > departureStationIndex) {
            for(int i = departureStationIndex; i <= arrivalStationIndex; i++)
                showStationNames.add(tempList.get(i));
        }
        else{
            for(int i = arrivalStationIndex; i <= departureStationIndex; i++)
                showStationNames.add(tempList.get(i));

            Collections.reverse(showStationNames);
        }
    }
}