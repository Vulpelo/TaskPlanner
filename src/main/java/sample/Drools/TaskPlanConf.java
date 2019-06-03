package sample.Drools;

import org.drools.planner.config.SolverFactory;
import org.drools.planner.config.XmlSolverFactory;
import org.drools.planner.core.Solver;

public class TaskPlanConf {
    public void solve () {
    // Build the Solver
    SolverFactory solverFactory = new XmlSolverFactory(
            "/Drools/taskPlanSolverConfig.xml");

    Solver solver = solverFactory.buildSolver();

    // Load a problem with 400 computer and 1200 processes
    TasksPlan unsolvedCloudBalance = new TasksPlanGenerator().generateTasksPlan();

    // Solve the problem
        solver.setPlanningProblem(unsolvedCloudBalance);
        solver.solve();

        TasksPlan solvedCloudBalance = (TasksPlan) solver.getBestSolution();

    // Display the result
        System.out.println("\nSolved cloudBalance with 400 computers and 1200 processes:\n");
    }
}
