package frc.robot.util.sim;

import edu.wpi.first.epilogue.Logged;
import edu.wpi.first.math.geometry.Pose3d;
import edu.wpi.first.math.geometry.Rotation3d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.StructArrayPublisher;
import edu.wpi.first.wpilibj.smartdashboard.Mechanism2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismLigament2d;
import edu.wpi.first.wpilibj.smartdashboard.MechanismRoot2d;
import org.littletonrobotics.junction.Logger;

@Logged
public class Mechanisms {
    private final MechanismLigament2d armLigament;

    private final StructArrayPublisher<Pose3d> realComponentPosePublisher = NetworkTableInstance.getDefault()
            .getStructArrayTopic("ComponentPoses/Real", Pose3d.struct)
            .publish();
    private final StructArrayPublisher<Pose3d> targetComponentPosePublisher = NetworkTableInstance.getDefault()
            .getStructArrayTopic("ComponentPoses/Target", Pose3d.struct)
            .publish();

    public Mechanisms() {
        // the main mechanism object
        Mechanism2d mech = new Mechanism2d(1, 3);
        // the mechanism root node
        MechanismRoot2d root = mech.getRoot("root", 2, 0);
        armLigament = root.append(new MechanismLigament2d("arm", 0.5, 90));
    }

    public void updateElevatorMech(double elevatorPos) {
        armLigament.setLength(Units.inchesToMeters((elevatorPos * 6) + 1));
    }

    public void publishComponentPoses(double elevatorPos, boolean useRealPoses) {
        double elevatorStageHeight = Units.inchesToMeters(elevatorPos * 8.6);
        double carriageHeight = Units.inchesToMeters(elevatorPos * 15);

        Logger.recordOutput(
                "ComponentPoses/" + (useRealPoses ? "Real" : "Target"),
                new Pose3d(
                        Units.inchesToMeters(-8),
                        0.0,
                        Units.inchesToMeters(2.625) + elevatorStageHeight,
                        Rotation3d.kZero),
                new Pose3d(
                        Units.inchesToMeters(-4.13),
                        0,
                        Units.inchesToMeters(10.22) + carriageHeight,
                        Rotation3d.kZero));
    }
}
