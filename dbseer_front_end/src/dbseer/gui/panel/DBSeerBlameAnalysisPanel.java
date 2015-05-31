package dbseer.gui.panel;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.util.HashMap;

/**
 * Created by dyoon on 5/10/15.
 */
public class DBSeerBlameAnalysisPanel extends JPanel
{
	private JLabel questionLabel;
	private JLabel questionMarkLabel;

	private JComboBox predictionTargetComboBox;

	public static final int TARGET_CPU = 0;
	public static final int TARGET_IO = 1;
	public static final int TARGET_LOCK = 2;

	public static String[] analysisTargets = {
			"high CPU usage",
			"high disk I/O (read/write)",
			"lock contention"
	};

	public static String[] analysisFunctions = {
			"BlameAnalysisCPU",
			"BlameAnalysisIO",
			"BlameAnalysisLock"
	};

	private HashMap<String, String> analysisFunctionMap;

	public DBSeerBlameAnalysisPanel()
	{
		this.setLayout(new MigLayout(""));
		analysisFunctionMap = new HashMap<String, String>();

		int idx = 0;
		for (String target : analysisTargets)
		{
			analysisFunctionMap.put(target, analysisFunctions[idx]);
			++idx;
		}

		initialize();
	}

	private void initialize()
	{
		questionLabel = new JLabel("Which transaction type is most responsible for the");
		questionMarkLabel = new JLabel("?");

		predictionTargetComboBox = new JComboBox(DBSeerBlameAnalysisPanel.analysisTargets);

		this.add(questionLabel);
		this.add(predictionTargetComboBox);
		this.add(questionMarkLabel);
	}

	public String getAnalysisFunction()
	{
		return analysisFunctionMap.get(predictionTargetComboBox.getSelectedItem());
	}

	public int getSelectedIndex()
	{
		return predictionTargetComboBox.getSelectedIndex();
	}
}
