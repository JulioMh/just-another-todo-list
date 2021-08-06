import { taskMiddleware } from "./task";
import { taskListMiddleware } from "./taskList";
import { uiMiddleware } from "./ui";

const middleware = [
  ...taskMiddleware,
  ...uiMiddleware,
  ...taskListMiddleware
]

export default middleware