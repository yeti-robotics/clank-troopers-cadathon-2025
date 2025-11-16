package frc.robot.commands;

import com.pathplanner.lib.auto.NamedCommands;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.hood.HoodSubsystem;
import frc.robot.subsystems.intake.IntakeSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;

public class AutoNamedCommands {
    private final IntakeSubsystem intake;
    private final ShooterSubsystem shooter;
    private final HoodSubsystem hood;

    public AutoNamedCommands(IntakeSubsystem intake, HoodSubsystem hood, ShooterSubsystem shooter) {
        this.intake = intake;
        this.shooter = shooter;
        this.hood = hood;
        registerCommands();
    }

    public void registerCommands() {
        NamedCommands.registerCommand(
                "shoot",
                shooter.startFlywheels(0.5)
                        .andThen(new WaitCommand(2)
                                .andThen(shooter.startFeeders(0.3).withTimeout(2))
                                .andThen(shooter.stopFlywheels())));

        // NamedCommands.registerCommands("deploy intake");
        // NamedCommands.registerCommands("stow intake");
    }
}
