package in.rauf.dao;

import in.rauf.entities.TaskEntity;
import in.rauf.models.TaskStatus;
import jakarta.transaction.Transactional;

public class TaskDao extends BaseDao<TaskEntity, Long> {

    public void updateStatus(Long id, TaskStatus taskStatus) {
        if (id == null || taskStatus == null) {
            return;
        }

        var taskEntity = findById(id);
        var entityManager = getEntityManager();
        entityManager.getTransaction().begin();

        if (taskEntity.isEmpty()) {
            return;
        }

        taskEntity.get().setStatus(taskStatus);
        entityManager.merge(taskEntity.get());
        entityManager.getTransaction().commit();
    }

    @Transactional
    public void delete(Long id) {
        if (id == null) {
            return;
        }
        findById(id).ifPresent(e -> {
//            if (e.getProperty() != null) {
//                e.getProperty().setTasks(null);
//            }
//            if (e.getAssignedTo() != null) {
//                e.getAssignedTo().setTasks(null);
//            }
//            e.setProperty(null);
//            e.setAssignedTo(null);
            remove(e);
        });
    }

}
