package frc.robot.commands;

import com.pathplanner.lib.auto.NamedCommands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.arm.ArmSubsystem;
import frc.robot.subsystems.hood.HoodSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class AutoNamedCommands {
    private final IntakeSubsystem intake;
    private final ShooterSubsystem shooter;
    private final ArmSubsystem arm;

    public AutoNamedCommands(IntakeSubsystem intake, ArmSubsystem arm, ShooterSubsystem shooter) {
        this.intake = intake;
        this.shooter = shooter;
        this.arm = arm;
        registerCommands();
    }

    public void registerCommands() {
        NamedCommands.registerCommand(
                "shoot",
                shooter.startFlywheels(0.5)
                        .andThen(new WaitCommand(2)
                                .andThen(shooter.startFeeders(0.3).withTimeout(2))
                                .andThen(shooter.stopFlywheels())));

        //NamedCommands.registerCommands("deploy intake", arm.moveToPosition(0));
        //NamedCommands.registerCommands("stow intake", arm.moveToPosition(0.75));
    }
}
