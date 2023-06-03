package com.example.railwaytimeprediction.platforms;
import static com.example.railwaytimeprediction.db.FragmentHome.databaseHelper;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
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
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.example.railwaytimeprediction.db.FragmentHome;
import com.example.railwaytimeprediction.R;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class FragmentTF2 extends Fragment {
    private Button escapeButton, startButton, departureButton, arrivalButton;
    private Boolean departureConfirm = false, arrivalConfirm = false;
    private ListView listView;
    private EditText editText;
    private ArrayList<String> stationNames;
    private ArrayList<Integer> stationRanges;
    private ArrayAdapter<String> arrayAdapter;
    private TextView titleTextView, firstMessage, secondMessage, thirdMessage, fourthLeftMessage,fourthRightMessage;
    private int departureStationIndex, arrivalStationIndex, Hour, Min;
    private String departureStationName, arrivalStationName, stringHour, stringMin;
    private Dialog dialog;
    private Switch aSwitch;
    private SimpleDateFormat sdfH, sdfM, currentDateAndTime;
    private String depTime;
    private String arrTime;
    private int StationCounter;
    private int totalMin;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_t_f2, container, false);

        departureButton = (Button) v.findViewById(R.id.departure_button);
        arrivalButton = (Button) v.findViewById(R.id.arrival_button);
        startButton = (Button) v.findViewById(R.id.start_button);
        escapeButton = (Button) v.findViewById(R.id.escape_button);
        aSwitch = (Switch) v.findViewById(R.id.switch_button);

        firstMessage = (TextView) v.findViewById(R.id.first_message);
        secondMessage = (TextView) v.findViewById(R.id.second_message);
        thirdMessage = (TextView) v.findViewById(R.id.third_message);
        fourthLeftMessage = (TextView) v.findViewById(R.id.fourth_left_message);
        fourthRightMessage = (TextView) v.findViewById(R.id.fourth_rigth_message);

        ArrayListImport();

        dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.dialog_searchable_spinner);
        dialog.getWindow().setLayout(800, 1200);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        editText = (EditText) dialog.findViewById(R.id.edit_text);
        titleTextView = (TextView) dialog.findViewById(R.id.select_station_title);

        listView = dialog.findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.text_view, stationNames);
        listView.setAdapter(arrayAdapter);

        departureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleTextView.setText(R.string.kalkis);
                dialog.show();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        departureStationName = (String) ((ListView) parent).getAdapter().getItem(position);

                        for(int i = 0; i < stationNames.size(); i++){
                            if(stationNames.get(i).equals(departureStationName)){
                                departureStationIndex = i;
                            }
                        }

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
                    }
                });
            }
        });

        arrivalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titleTextView.setText(R.string.varis);
                dialog.show();

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        arrivalStationName = (String) ((ListView) parent).getAdapter().getItem(position);

                        for(int i = 0; i < stationNames.size(); i++){
                            if(stationNames.get(i).equals(arrivalStationName)){
                                arrivalStationIndex = i;
                            }
                        }

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
                    }
                });
            }
        });

        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
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

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setHourMinVariables();

                if (departureConfirm && arrivalConfirm) {

                    totalMin = countMin();
                    depTime = getDepTime(stringHour, stringMin);
                    arrTime = getArrivalTime(totalMin);
                    StationCounter = (Math.abs(departureStationIndex - arrivalStationIndex));

                    firstMessage.setText(departureStationName);
                    secondMessage.setText(arrivalStationName);
                    thirdMessage.setText(depTime + "->" + arrTime);
                    fourthLeftMessage.setText(totalMin + " Dakika");
                    fourthRightMessage.setText(StationCounter + " Durak");

                    firstMessage.setVisibility(View.VISIBLE);
                    secondMessage.setVisibility(View.VISIBLE);
                    thirdMessage.setVisibility(View.VISIBLE);
                    fourthLeftMessage.setVisibility(View.VISIBLE);
                    fourthRightMessage.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(getActivity(), "Boş Bırakılan Alanlar Var", Toast.LENGTH_LONG).show();
                }

                currentDateAndTime = new SimpleDateFormat("yyyy.MM.dd", Locale.getDefault());
                String dateAndTime = currentDateAndTime.format(new Date());

                databaseHelper.insertData("tf2", dateAndTime, departureStationName, arrivalStationName, depTime, arrTime, StationCounter, totalMin);
            }
        });

        escapeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new FragmentHome()).commit();
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                arrayAdapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        return v;
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

            sdfH = new SimpleDateFormat("HH");
            sdfM = new SimpleDateFormat("mm");

            Hour = new Integer(Integer.valueOf(sdfH.format(new Date())));
            Min = new Integer(Integer.valueOf(sdfM.format(new Date())));

            if(Hour < 9) {
                stringHour = "0" + Integer.toString(Hour);
            } else {
                stringHour = Integer.toString(Hour);
            }

            if(Min < 9) {
                stringMin = "0" + Integer.toString(Min);
            } else {
                stringMin = Integer.toString(Min);
            }
        } else {
            if(Hour < 9) {
                stringHour = "0" + Integer.toString(Hour);
            } else {
                stringHour = Integer.toString(Hour);
            }

            if(Min < 9) {
                stringMin = "0" + Integer.toString(Min);
            } else {
                stringMin = Integer.toString(Min);
            }
        }
    }

    public String getDepTime(String stringHour, String stringMin) {
        String currentDateAndTime;
        int H = Integer.valueOf(stringHour);
        int M = Integer.valueOf(stringMin);
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

    public void ArrayListImport() {
        stationNames = new ArrayList<>();

        stationNames.add("Eyüp");
        stationNames.add("Piyer Loti");


        stationRanges = new ArrayList<>();

        stationRanges.add(3);
    }
}
