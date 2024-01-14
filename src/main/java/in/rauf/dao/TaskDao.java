package in.rauf.dao;

import in.rauf.entities.TaskEntity;
import in.rauf.models.TaskStatus;

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
}
