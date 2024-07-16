window.onload = function() {
    const taskUpdateForm = document.taskUpdateForm;

    document.getElementsByName('editBtn').forEach((btn) => {
        const taskId = btn.value;
        btn.addEventListener('click', () => {
            const task = taskList.find((t) => t.id === taskId);
            taskUpdateForm.id.value = task.id;
            taskUpdateForm.title.value = task.title;
            taskUpdateForm.deadline.value = task.deadline;
            taskUpdateForm.hasDone.checked = task.isCompleted;
        });
    });

    document.getElementById('updateBtn').addEventListener('click', () => {
        taskUpdateForm.isCompleted.value = taskUpdateForm.hasDone.checked;
        taskUpdateForm.submit();
    });
}


